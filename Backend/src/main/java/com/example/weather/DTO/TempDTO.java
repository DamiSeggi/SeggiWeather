package com.example.weather.DTO;

public class TempDTO {
    private String city;
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
