package com.example.weather.DTO;

public class WeatherDTO {
    private String city;
    private String condition;
    private double temperature; // °C
    private int humidity;       // %
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