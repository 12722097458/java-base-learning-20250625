package com.ityj.springboot.controller;

import com.ityj.springboot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RpcController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/webClient/{area}")
    public Mono<String> webClient(@PathVariable("area") String area) {
        //Mono<String> mono = weatherService.recentWeather(area);
        Mono<String> mono = weatherService.getWeather(area);
        return mono;
    }

}
