package com.ityj.springboot.config;

import com.ityj.springboot.component.MyYmlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

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

            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

                //converters.add(new MyYmlHttpMessageConverter());


            }

        };
        return webMvcConfigurer;
    };

}
