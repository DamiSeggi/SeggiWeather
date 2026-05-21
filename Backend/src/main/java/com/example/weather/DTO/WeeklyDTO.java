package com.example.weather.DTO;

import java.util.List;

public class WeeklyDTO {

    private String city;
    private List<DailyDTO> forecast;

    public WeeklyDTO(String city, List<DailyDTO> forecast) {
        this.city = city;
        this.forecast = forecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<DailyDTO> getForecast() {
        return forecast;
    }

    public void setForecast(List<DailyDTO> forecast) {
        this.forecast = forecast;
    }
}