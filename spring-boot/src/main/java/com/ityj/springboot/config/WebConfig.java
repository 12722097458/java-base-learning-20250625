package com.ityj.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc  会关闭mvc的所有自动配置。
// @EnableWebMvc  -> DelegatingWebMvcConfiguration -> 实例化了WebMvcConfigurationSupport。
// @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
//public class WebMvcAutoConfiguration {}  需要没有WebMvcConfigurationSupport才开始实例化。。
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry); // 保留原有配置
        registry.addResourceHandler("/pages/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(12);
    }
}
