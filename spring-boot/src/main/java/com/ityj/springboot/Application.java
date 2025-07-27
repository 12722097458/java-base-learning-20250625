package com.ityj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@Import(SpaceAutoConfiguration.class)
//@EnableSpace
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Application.class, args);
        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {

            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        Object error = ioc.getBean("error");  // class org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$StaticView
        System.out.println(error.getClass());
    }

}
