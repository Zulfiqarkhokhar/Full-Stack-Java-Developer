package com.example.SmallTasks.controller;

import com.example.SmallTasks.dto.WeatherResponseDto;
import com.example.SmallTasks.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiConsumerController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<?> getWeather(){

        WeatherResponseDto weatherResponseDto = weatherService.getWeather();
        String greetings = "";
        if (weatherResponseDto != null){
            greetings = weatherResponseDto.getWeather().get(0).getDescription();
        }
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }
}
