package com.exchangeinfo.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class WeatherDTO implements Serializable {

    @JsonProperty("cod")
    private int cod;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("dt")
    private int dt;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("visibility")
    private int visibility;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("base")
    private String base;
    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("coord")
    private Coord coord;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public static class Sys {
        @JsonProperty("sunset")
        private int sunset;
        @JsonProperty("sunrise")
        private int sunrise;
        @JsonProperty("country")
        private String country;
        @JsonProperty("message")
        private double message;
        @JsonProperty("id")
        private int id;
        @JsonProperty("type")
        private int type;

        public int getSunset() {
            return sunset;
        }

        public void setSunset(int sunset) {
            this.sunset = sunset;
        }

        public int getSunrise() {
            return sunrise;
        }

        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public double getMessage() {
            return message;
        }

        public void setMessage(double message) {
            this.message = message;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static class Clouds {
        @JsonProperty("all")
        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }
    }

    public static class Wind {
        @JsonProperty("deg")
        private int deg;
        @JsonProperty("speed")
        private int speed;

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }

    public static class Main {
        @JsonProperty("temp_max")
        private int temp_max;
        @JsonProperty("temp_min")
        private int temp_min;
        @JsonProperty("humidity")
        private int humidity;
        @JsonProperty("pressure")
        private int pressure;
        @JsonProperty("temp")
        private int temp;

        public int getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(int temp_max) {
            this.temp_max = temp_max;
        }

        public int getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(int temp_min) {
            this.temp_min = temp_min;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }
    }

    public static class Weather {
        @JsonProperty("icon")
        private String icon;
        @JsonProperty("description")
        private String description;
        @JsonProperty("main")
        private String main;
        @JsonProperty("id")
        private int id;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Coord {
        @JsonProperty("lat")
        private double lat;
        @JsonProperty("lon")
        private double lon;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }
}
