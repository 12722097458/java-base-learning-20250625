package com.ityj.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer {


    // org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration.setConfigurers
    // public void setConfigurers(List<WebMvcConfigurer> configurers) {} 会把所有的WebMvcConfigurer bean都注入
    @Bean
    public WebMvcConfigurer webMvcConfigurer () {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/pages/**")
                        .addResourceLocations("classpath:/static/")
                        .setCachePeriod(12);
            }
        };
        return webMvcConfigurer;
    };

}
