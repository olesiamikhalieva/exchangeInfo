package com.exchangeinfo.demo.controller;

import com.exchangeinfo.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WeatherJSPController {

    @Autowired
    WeatherService weatherService;


    @GetMapping("getWeatherFromOpenweathermap")
    public String index(Model model) {
        model.addAttribute("weatherList",weatherService.getWeatherDTOresponseListFromDB());
        return "index";
    }
}
