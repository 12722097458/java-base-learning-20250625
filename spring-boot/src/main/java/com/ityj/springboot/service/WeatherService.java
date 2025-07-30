package com.ityj.springboot.service;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

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


    public Mono<String> getWeather(String city) {

        WebClient webClient = WebClient.builder().baseUrl("https://ali-weather.showapi.com")
                .codecs(new Consumer<ClientCodecConfigurer>() {
                    @Override
                    public void accept(ClientCodecConfigurer clientCodecConfigurer) {
                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(256 * 1024 * 1024);
                    }
                }).build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
        WeatherInterface weatherInterface = httpServiceProxyFactory.createClient(WeatherInterface.class);
        return weatherInterface.getWeather(city, "APPCODE c402f4f54f874e25bf75094c2e332c56");
    }

}
