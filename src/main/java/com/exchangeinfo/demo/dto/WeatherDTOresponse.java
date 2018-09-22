package com.exchangeinfo.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherDTOresponse {
    @JsonProperty("tempMax")
    private int tempMax;
    @JsonProperty("tempMin")
    private int tempMin;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("nameCity")
    private String nameCity;
    @JsonProperty("cloudList")
    private List<CloudWeatherDTO> cloudList;
    @JsonProperty("date")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public List<CloudWeatherDTO> getCloudList() {
        return cloudList;
    }

    public void setCloudList(List<CloudWeatherDTO> cloudList) {
        this.cloudList = cloudList;
    }

    public static class CloudWeatherDTO {

        @JsonProperty("description")
        private String description;
        @JsonProperty("main")
        private String main;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }


    }

}
