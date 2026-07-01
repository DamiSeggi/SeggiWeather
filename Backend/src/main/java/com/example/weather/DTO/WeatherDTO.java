package com.example.weather.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Current weather conditions for a city")
public class WeatherDTO {

    @Schema(description = "Name of the city", example = "Zurich")
    private String city;

    @Schema(description = "Weather condition description", example = "Partly cloudy")
    private String condition;

    @Schema(description = "Current temperature in degrees Celsius", example = "18.3")
    private double temperature; // °C

    @Schema(description = "Relative humidity in percent", example = "65")
    private int humidity;       // %

    @Schema(description = "Wind speed in meters per second", example = "3.2")
    private double windSpeed;   // m/s

    public WeatherDTO(String city, String condition, double temperature, int humidity, double windSpeed){
        this.city = city;
        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature(){
        return temperature;
    }

    public String getCondition(){
        return condition;
    }

    public int getHumidity(){
        return humidity;
    }

    public double getWindSpeed(){
        return windSpeed;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    public void setHumidity(int humidity){
        this.humidity = humidity;
    }

    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }
}