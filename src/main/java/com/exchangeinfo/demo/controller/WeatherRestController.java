package com.exchangeinfo.demo.controller;

import com.exchangeinfo.demo.dto.WeatherDTOresponse;
import com.exchangeinfo.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class WeatherRestController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public List<WeatherDTOresponse> getWeather() {

        weatherService.addWeatherEntityToDB();
        return weatherService.getWeatherDTOresponseListFromDB();
    }


}
