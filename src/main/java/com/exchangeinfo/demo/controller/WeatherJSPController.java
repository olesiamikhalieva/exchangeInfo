package com.exchangeinfo.demo.controller;

import com.exchangeinfo.demo.dto.WeatherDTOresponse;
import com.exchangeinfo.demo.service.JsonService;
import com.exchangeinfo.demo.service.WeatherService;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class WeatherJSPController {

    @Autowired
    JsonService jsonService;


    @GetMapping("getWeatherFromOpenweathermap")
    public String index(Model model) {
        model.addAttribute("weatherJson",jsonService.createJsonObjFromWeatherDTOresponse());
        return "index";
    }
}
