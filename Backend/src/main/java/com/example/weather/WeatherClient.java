package com.example.weather;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.weather.DTO.TempDTO;
import com.example.weather.DTO.WeatherDTO;
import com.example.weather.DTO.WeeklyDTO;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WeatherClient {
    // API Key from application.properties
    @Value("${weather.api.key}") 
    private String api_key;
    // Base URL of endpoint
    private final String base_url = "https://api.openweathermap.org/";
    // OkHttp Client
    private final OkHttpClient client = new OkHttpClient();

    public WeatherDTO getCurrentWeather(String city) throws IOException{

    }
    
    public TempDTO getCurrentTemp(String city) throws IOException {
        Request request = new Request.Builder()
                .url(base_url + "data/2.5/weather?q=" + city + "&appid=" + api_key + "&units=metric")
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body().string());
            double temp = root.get("main").get("temp").asDouble();

            return new TempDTO(city, temp);
        }
    }

    public WeeklyDTO getWeekForecast(String city) throws IOException{

    }
}
