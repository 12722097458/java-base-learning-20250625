package com.ityj.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaseLearningApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(BaseLearningApplication.class, args);
        for (String beanDefinitionName : ac.getBeanDefinitionNames()) {

            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

}
