package com.exchangeinfo.demo.controller;

import com.exchangeinfo.demo.service.JsonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Log4j2
public class WeatherJSPController {

    @Autowired
    JsonService jsonService;


    @GetMapping("getWeatherFromOpenweathermap")
    public String index(Model model) {
        model.addAttribute("weatherJson",jsonService.createJsonObjFromWeatherDTOresponse());
        log.info(jsonService.createJsonObjFromWeatherDTOresponse());
        return "index";
    }
}
