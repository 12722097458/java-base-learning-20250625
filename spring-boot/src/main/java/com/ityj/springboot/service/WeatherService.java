package com.ityj.springboot.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherService {

    public Mono<String> recentWeather(String city) {

        WebClient webClient = WebClient.create();
        Map<String, String> map = new HashMap<>();
        map.put("area", city);
        Mono<String> mono = webClient.get()
                .uri("https://ali-weather.showapi.com/hour24?area={area}", map)
                .header("Authorization", "APPCODE c402f4f54f874e25bf75094c2e332c56")
                .acceptCharset(Charset.defaultCharset())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }


}
