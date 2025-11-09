package com.example.weatherapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.weatherapp.model.WeatherData;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.open-meteo.com").build();
    }

    public Mono<WeatherData> getTorontoWeather() {
        String url = "/v1/forecast?latitude=43.7&longitude=-79.42&hourly=temperature_2m";
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(WeatherData.class);
    }
}
