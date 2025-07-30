package com.ityj.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

@MapperScan(basePackages = "com.ityj.springboot.mapper") // 导入包下的所有mapper
@SpringBootApplication
@EnableKafka
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
