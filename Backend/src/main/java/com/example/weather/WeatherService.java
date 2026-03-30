package com.example.weather;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.weather.DTO.TempDTO;
import com.example.weather.DTO.WeatherDTO;
import com.example.weather.DTO.WeeklyDTO;

@Service
public class WeatherService {
    private WeatherClient client;
    
    public WeatherService(WeatherClient client){
        this.client = client;
    }

    public WeatherDTO getCurrentWeather(String city){
        try {
            return client.getCurrentWeather(city);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public TempDTO getCurrentTemp(String city){
        try {
            return client.getCurrentTemp(city);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     public WeeklyDTO getWeekForecast(String city){
        return client.getWeekForecast(city);
    }

}
