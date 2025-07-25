package com.ityj.space.config;

import com.ityj.space.controller.SpaceController;
import com.ityj.space.property.SpaceProperties;
import com.ityj.space.service.SpaceService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(SpaceProperties.class)
@Configuration
public class SpaceAutoConfiguration {

    @Bean
    public SpaceService getSpaceService() {
        return new SpaceService();
    }

    @Bean
    public SpaceController getSpaceController() {
        SpaceController spaceController = new SpaceController();
        return spaceController;
    }

}
