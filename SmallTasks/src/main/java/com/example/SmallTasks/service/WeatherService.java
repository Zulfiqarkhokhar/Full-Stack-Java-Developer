package com.example.SmallTasks.service;

import com.example.SmallTasks.dto.WeatherResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    private static final String API_KEY = "fbe15210c44ab4246ac914cd54584a08";

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=";

    @Autowired
    private RestTemplate restTemplate;


    public WeatherResponseDto getWeather(){
        String url = BASE_URL + API_KEY;

        ResponseEntity<WeatherResponseDto> response = restTemplate.exchange(url, HttpMethod.GET, null, WeatherResponseDto.class);
        WeatherResponseDto weatherResponseDto = response.getBody();
        return weatherResponseDto;

    }
}
