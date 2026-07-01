package com.example.weather;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.weather.DTO.TempDTO;
import com.example.weather.DTO.WeatherDTO;
import com.example.weather.DTO.DailyDTO;
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
            String condition = root.get("weather").get(0).get("main").asText();
            int humidity = root.get("main").get("humidity").asInt();
            double windSpeed = root.get("wind").get("speed").asDouble();


            return new WeatherDTO(city, condition, temp, humidity, windSpeed);
        }
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

   public WeeklyDTO getWeekForecast(String city) throws IOException {
    Request request = new Request.Builder()
            .url(base_url + "data/2.5/forecast?q=" + city + "&appid=" + api_key + "&units=metric")
            .get()
            .build();

    try (Response response = client.newCall(request).execute()) {
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.body().string());
        JsonNode list = root.get("list");

        Map<String, DailyDTO> daysMap = new TreeMap<>();

        for (JsonNode forecast : list) {
            long dt = forecast.get("dt").asLong();
            Date date = new Date(dt * 1000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdf.format(date);

            double tempMin = forecast.get("main").get("temp_min").asDouble();
            double tempMax = forecast.get("main").get("temp_max").asDouble();
            String condition = forecast.get("weather").get(0).get("main").asText();

            if (!daysMap.containsKey(dateStr)) {
                daysMap.put(
                    dateStr,
                    new DailyDTO(dateStr, tempMin, tempMax, condition)
                );
            } else {
                DailyDTO existing = daysMap.get(dateStr);
                daysMap.put(
                    dateStr,
                    new DailyDTO(
                        dateStr, Math.min(existing.getMinTemp(), tempMin),
                        Math.max(existing.getMaxTemp(), tempMax),
                        existing.getCondition()
                    )
                );
            }
        }

        List<DailyDTO> days = new ArrayList<>(daysMap.values());
        return new WeeklyDTO(city, days);
    }
}
}
