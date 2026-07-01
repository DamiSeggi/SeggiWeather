package com.example.weather.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Current temperature for a city")
public class TempDTO {

    @Schema(description = "Name of the city", example = "Zurich")
    private String city;

    @Schema(description = "Current temperature in degrees Celsius", example = "18.3")
    private double temp;

    public TempDTO(String city, double temp){
        this.city = city;
        this.temp = temp;
    }

    public String getCity(){
        return city;
    }

    public double getTemp(){
        return temp;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setTemp(double temp){
        this.temp = temp;
    }
}