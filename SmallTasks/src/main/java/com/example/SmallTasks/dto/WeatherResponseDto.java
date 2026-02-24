package com.example.SmallTasks.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Setter
@Getter
public class WeatherResponseDto{
    private Cord cord;
    private ArrayList<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
    private static class Clouds{
        private int all;
    }

    @Setter
    @Getter
    public static class Cord {
        private double lon;
        private double lat;
    }

    @Setter
    @Getter
    public static class Main{
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;
    }
    @Setter
    @Getter
    public static class Sys{
        private String country;
        private int sunrise;
        private int sunset;
    }

    @Setter
    @Getter
    public static class Weather{
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Setter
    @Getter
    public static class Wind{
        private double speed;
        private int deg;
        private double gust;
    }


}

