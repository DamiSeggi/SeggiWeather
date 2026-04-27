package com.example.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.weather.DTO.TempDTO;
import com.example.weather.DTO.WeatherDTO;
import com.example.weather.DTO.WeeklyDTO;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {
    
    @Mock
    WeatherClient client;

    @InjectMocks
    WeatherService service;
    
   @Test
    void getCurrentWeather_test() throws IOException {
        WeatherDTO dto = new WeatherDTO("a", "rain", 10.0, 10, 10.0);

        when(client.getCurrentWeather("a")).thenReturn(dto);

        WeatherDTO result = service.getCurrentWeather("a");

        assertEquals(dto.getCity(), result.getCity());
        assertEquals(dto.getCondition(), result.getCondition());
        assertEquals(dto.getTemperature(), result.getTemperature());
        assertEquals(dto.getHumidity(), result.getHumidity());
        assertEquals(dto.getWindSpeed(), result.getWindSpeed());
        verify(client).getCurrentWeather("a");
    }

    @Test
    void getCurrentWeather_shouldThrowRuntimeException() throws IOException {
        when(client.getCurrentWeather("a")).thenThrow(IOException.class);

        assertThrows(RuntimeException.class, () -> {
            service.getCurrentWeather("a");
        });
    }

    @Test
    void getCurrentTemp_test() throws IOException{
        TempDTO dto = new TempDTO("a", 10.0);

        when(client.getCurrentTemp("a")).thenReturn(dto);

        TempDTO result = service.getCurrentTemp("a");

        assertEquals(dto.getCity(), result.getCity());
        assertEquals(dto.getTemp(), result.getTemp());
        verify(client).getCurrentTemp("a");
    }

    @Test
    void getCurrentTemp_shouldThrowRuntimeException() throws IOException {
        when(client.getCurrentTemp("a")).thenThrow(IOException.class);

        assertThrows(RuntimeException.class, () -> {
            service.getCurrentTemp("a");
        });
    }

    @Test
    void getWeekForecast_test() throws IOException {
        WeeklyDTO dto = new WeeklyDTO(
            "a",
            "2026-01-01", 1.0, 5.0, "sun",
            "2026-01-02", 2.0, 6.0, "rain",
            "2026-01-03", 3.0, 7.0, "cloudy",
            "2026-01-04", 4.0, 8.0, "sun",
            "2026-01-05", 5.0, 9.0, "rain",
            "2026-01-06", 6.0, 10.0, "storm"
        );

        when(client.getWeekForecast("a")).thenReturn(dto);

        WeeklyDTO result = service.getWeekForecast("a");

        assertEquals(dto.getCity(), result.getCity());
        assertEquals(dto.getDay1Date(), result.getDay1Date());
        assertEquals(dto.getDay1MinTemp(), result.getDay1MinTemp());
        assertEquals(dto.getDay1Condition(), result.getDay1Condition());
        verify(client).getWeekForecast("a");
    }

    @Test
    void getWeekForecast_shouldThrowRuntimeException() throws IOException {
        when(client.getWeekForecast("a")).thenThrow(IOException.class);

        assertThrows(RuntimeException.class, () -> {
            service.getWeekForecast("a");
        });
    }

}
