package com.cydeo.client;

import com.cydeo.dto.country.CountryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url ="https://restcountries.com/v3.1",name = "COUNTRY-CLIENT")
public interface CountryApiClient {

    @GetMapping("/name/{country}")
    List<CountryResponse> getCountry(@PathVariable("country")String country);
}
//https://restcountries.com/v3.1/name/deutschland