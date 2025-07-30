package com.ityj.springboot.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface WeatherInterface {

    @GetExchange(url = "/hour24")
    Mono<String> getWeather(@RequestParam("area") String city,
                            @RequestHeader("Authorization") String auth);

}
