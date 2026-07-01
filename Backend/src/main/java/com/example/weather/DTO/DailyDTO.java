package com.example.weather.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Weather forecast for a single day")
public class DailyDTO {

    @Schema(description = "Date of the forecast", example = "2026-07-01")
    private String date;

    @Schema(description = "Minimum temperature in degrees Celsius", example = "14.5")
    private double minTemp;

    @Schema(description = "Maximum temperature in degrees Celsius", example = "23.8")
    private double maxTemp;

    @Schema(description = "Weather condition description", example = "Partly cloudy")
    private String condition;

    public DailyDTO(String date, double minTemp, double maxTemp, String condition) {
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.condition = condition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}