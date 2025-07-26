package com.ityj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@Import(SpaceAutoConfiguration.class)
//@EnableSpace
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {

            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

}
