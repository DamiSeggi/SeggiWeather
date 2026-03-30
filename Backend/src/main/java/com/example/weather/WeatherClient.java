package com.example.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.weather.DTO.TempDTO;
import com.example.weather.DTO.WeatherDTO;
import com.example.weather.DTO.WeeklyDTO;

import okhttp3.OkHttpClient;

@Component
public class WeatherClient {
    // API Key from application.properties
    @Value("${weather.api.key}") 
    private String api_key;
    // Base URL of endpoint
    private final String base_url = "https://api.openweathermap.org/";
    // OkHttp Client
    private final OkHttpClient client = new OkHttpClient();

    public WeatherDTO getCurrentWeather(String city){

    }

    public TempDTO getCurrentTemp(String city){

    }

    public WeeklyDTO getWeekForecast(String city){

    }
}
