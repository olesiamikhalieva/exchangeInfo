package com.exchangeinfo.demo.service;

import com.exchangeinfo.demo.dto.WeatherDTOresponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JsonService {
    @Autowired
    WeatherService weatherService;

    public JSONObject createJsonObjFromWeatherDTOresponse(){
        JSONObject obj = new JSONObject();
        for (WeatherDTOresponse weatherDTOresponse : weatherService.getWeatherDTOresponseListFromDB()) {
            obj.put("nameCity",weatherDTOresponse.getNameCity());
            obj.put("pressure",weatherDTOresponse.getPressure());
            obj.put("tempMin",weatherDTOresponse.getTempMin());
            obj.put("tempMax",weatherDTOresponse.getTempMax());
            obj.put("date",weatherDTOresponse.getDate());
            JSONArray jsonArray = new JSONArray();
            Map<String,String> map = new HashMap<>();
            for (WeatherDTOresponse.CloudWeatherDTO cloudWeatherDTO : weatherDTOresponse.getCloudList()) {
                map.put("main",cloudWeatherDTO.getMain());
                map.put("description",cloudWeatherDTO.getDescription());
            }
            JSONObject obj2 = new JSONObject();
            obj2.putAll(map);
            jsonArray.add(obj2);
            obj.put("CloudWeather", jsonArray);
        }
        return obj;
    }
}
