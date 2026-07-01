package com.example.weather;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.DTO.TempDTO;
import com.example.weather.DTO.WeatherDTO;
import com.example.weather.DTO.WeeklyDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Weather", description = "Endpoints for retrieving current and forecasted weather data")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/")
public class WeatherController {
    private WeatherService service;

    public WeatherController(WeatherService service){
        this.service = service;
    }

    @Operation(summary = "Get current weather conditions for a city")
    @GetMapping("current/weather/{city}")
    public WeatherDTO getCurrentWeather(@Parameter(description = "City name") @PathVariable String city){
        return service.getCurrentWeather(city);
    }

    @Operation(summary = "Get current temperature for a city")
    @GetMapping("current/temp/{city}")
    public TempDTO getCurrentTemp(@Parameter(description = "City name") @PathVariable String city){
        return service.getCurrentTemp(city);
    }
    
    @Operation(summary = "Get weekly weather forecast for a city")
    @GetMapping("weekly/{city}")
    public WeeklyDTO getWeekForecast(@Parameter(description = "City name") @PathVariable String city){
        return service.getWeekForecast(city);
    }
}