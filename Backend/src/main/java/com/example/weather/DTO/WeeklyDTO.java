package com.example.weather.DTO;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Weekly weather forecast for a city")
public class WeeklyDTO {

    @Schema(description = "Name of the city", example = "Zurich")
    private String city;

    @Schema(description = "List of daily forecasts for the upcoming week")
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