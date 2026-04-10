package com.example.weather;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.DTO.TempDTO;
import com.example.weather.DTO.WeatherDTO;
import com.example.weather.DTO.WeeklyDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/")
public class WeatherController {
    private WeatherService service;

    public WeatherController(WeatherService service){
        this.service = service;
    }

    @GetMapping("current/weather/{city}")
    public WeatherDTO getCurrentWeather(@PathVariable String city){
        return service.getCurrentWeather(city);
    }

    @GetMapping("current/temp/{city}")
    public TempDTO getCurrentTemp(@PathVariable String city){
        return service.getCurrentTemp(city);
    }
    
    @GetMapping("weekly/{city}")
    public WeeklyDTO getWeekForecast(@PathVariable String city){
        return service.getWeekForecast(city);
    }
}
