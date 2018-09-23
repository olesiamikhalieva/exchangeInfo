package com.exchangeinfo.demo.service;

import com.exchangeinfo.demo.dao.entity.CloudEntity;
import com.exchangeinfo.demo.dao.entity.WeatherEntity;
import com.exchangeinfo.demo.dao.repository.WeatherRepository;
import com.exchangeinfo.demo.dto.WeatherDTO;
import com.exchangeinfo.demo.dto.WeatherDTOresponse;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Log4j2
public class WeatherService {
    @Autowired
    WeatherRepository weatherRepository;

    static final String URL_WEATHER = "http://api.openweathermap.org/data/2.5/weather?q=dnipro&units=metric&appid=259ed2e03585b4c9c3b924564ecbeddd";

    private WeatherDTO constructWeatherDTOFromURL_WEATHER() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherDTO weatherDTO = restTemplate
                .getForObject(URL_WEATHER, WeatherDTO.class);
        log.info("weather", weatherDTO);
        return weatherDTO;
    }

    private WeatherEntity constructWeatherEntityFromWeatherDTO(WeatherDTO weatherDTO) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setNameCity(weatherDTO.getName());
        weatherEntity.setPressure(weatherDTO.getMain().getPressure());
        List<CloudEntity> weatherList = new ArrayList<>();
        for (WeatherDTO.Weather weather : weatherDTO.getWeather()) {
            CloudEntity cloudEntity = new CloudEntity();
            cloudEntity.setMain(weather.getMain());
            cloudEntity.setDescription(weather.getDescription());
            weatherList.add(cloudEntity);
        }
        weatherEntity.setCloudEntityList(weatherList);
        weatherEntity.setTempMax(weatherDTO.getMain().getTemp_max());
        weatherEntity.setTempMin(weatherDTO.getMain().getTemp_min());
        Date date = new Date();
        weatherEntity.setDate(date.toString());
        return weatherEntity;
    }

    public void addWeatherEntityToDB() {
        WeatherEntity weatherEntity = constructWeatherEntityFromWeatherDTO(constructWeatherDTOFromURL_WEATHER());
        weatherRepository.saveAndFlush(weatherEntity);
    }

    public List<WeatherDTOresponse> getWeatherDTOresponseListFromDB() {
        List<WeatherDTOresponse> weatherDTOresponseList= new ArrayList<>();
        for (WeatherEntity weather : weatherRepository.findAll()) {
            weatherDTOresponseList.add(constructWeatherDTOresponse(weather));
        }
        return weatherDTOresponseList;
    }

    private WeatherDTOresponse constructWeatherDTOresponse(WeatherEntity weatherEntity) {
        WeatherDTOresponse weatherDTOresponse = new WeatherDTOresponse();
        weatherDTOresponse.setNameCity(weatherEntity.getNameCity());
        weatherDTOresponse.setPressure(weatherEntity.getPressure());
        weatherDTOresponse.setTempMax(weatherEntity.getTempMax());
        weatherDTOresponse.setTempMin(weatherEntity.getTempMin());

        List<WeatherDTOresponse.CloudWeatherDTO> cloudWeatherDTOList = new ArrayList<>();
        for (CloudEntity cloudEntity : weatherEntity.getCloudEntityList()) {
            WeatherDTOresponse.CloudWeatherDTO cloudWeatherDTO = new WeatherDTOresponse.CloudWeatherDTO();
            cloudWeatherDTO.setDescription(cloudEntity.getDescription());
            cloudWeatherDTO.setMain(cloudEntity.getMain());
            cloudWeatherDTOList.add(cloudWeatherDTO);
        }
        weatherDTOresponse.setDate(weatherEntity.getDate());
        weatherDTOresponse.setCloudList(cloudWeatherDTOList);
        return weatherDTOresponse;
    }
}
