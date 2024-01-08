package com.cydeo.client;

import com.cydeo.dto.weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com",name = "WEATHER-CLIENT")
public interface WeatherApiClient {


    //http://api.weatherstack.com
    // /current
    // ?access_key=7ff03d2870ca9d2d809464765b9ea04e
    // &
    // query=İstanbul
@GetMapping("/current")
WeatherResponse getCurrentWeather(@RequestParam (value = "access_key")String accessKey, @RequestParam(value = "query")String city);

       }