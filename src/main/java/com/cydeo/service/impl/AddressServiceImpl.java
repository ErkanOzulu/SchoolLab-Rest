package com.cydeo.service.impl;

import com.cydeo.client.CountryApiClient;
import com.cydeo.client.WeatherApiClient;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.country.CountryResponse;
import com.cydeo.dto.weather.WeatherResponse;
import com.cydeo.entity.Address;
import com.cydeo.exception.NotFoundException;
import com.cydeo.util.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Value("${access_key}")
    private String accessKey;
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final WeatherApiClient weatherApiClient;
    private final CountryApiClient countryApiClient;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, WeatherApiClient weatherApiClient, CountryApiClient countryApiClient) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.weatherApiClient = weatherApiClient;
        this.countryApiClient = countryApiClient;
    }

    @Override
    public List<AddressDTO> findAll() {
        List<AddressDTO> addresses = addressRepository.findAll()
                .stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO())).
                collect(Collectors.toList());
        for (AddressDTO addressDTO : addresses) {

            addressDTO.setCurrentTemperature(retrieveTemperatureByCity(addressDTO.getCity()));
            addressDTO.setFlag(retrieveFlagByCountry(addressDTO.getCountry()));
        }

        return addresses;

    }

    @Override
    public AddressDTO findById(Long id) throws Exception {
        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Address Found!"));
        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());
        //we will get the current temperature and set based on city, the return dto
        addressDTO.setCurrentTemperature(retrieveTemperatureByCity(addressDTO.getCity()));
        addressDTO.setFlag(retrieveFlagByCountry(addressDTO.getCountry()));
        return addressDTO;
    }

    private String retrieveFlagByCountry(String country) {
        try {
            List<CountryResponse> countryResponses = countryApiClient.getCountry(country);

            if (countryResponses.size() == 0 || countryResponses.get(0).getFlags().getPng() == null) {
                return "Flag not found";
            }
            return countryResponses.get(0).getFlags().getPng();
        } catch (FeignException.NotFound e) {
            return "Flag not found";
        }
    }




    private Integer retrieveTemperatureByCity(String city) {

        WeatherResponse weatherResponse = weatherApiClient.getCurrentWeather(accessKey, city);
        if (weatherResponse == null || weatherResponse.getCurrent() == null) {
            return null;
        }
        return weatherResponse.getCurrent().getTemperature();
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new NotFoundException("No Address Found!"));

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(addressDTO.getId());

        if (foundAddress.isPresent()) {
            throw new Exception("Address Already Exists!");
        }

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

}