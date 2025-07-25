package com.ityj.springboot;

import com.ityj.space.anno.EnableSpace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Import(SpaceAutoConfiguration.class)
//@EnableSpace
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
