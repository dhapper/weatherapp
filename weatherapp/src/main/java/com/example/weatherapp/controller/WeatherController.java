package com.example.weatherapp.controller;

import com.example.weatherapp.model.DisplayData;
import com.example.weatherapp.model.WeatherData;
import com.example.weatherapp.service.WeatherService;
import com.example.weatherapp.util.DataManip;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String showWeather(Model model) {
        WeatherData data = weatherService.getTorontoWeather().block();
        DisplayData displayData = DataManip.transformToDisplayData(data);

        model.addAttribute("weather", data);
        model.addAttribute("display", displayData);

        return "index";
    }
}
