package com.ityj.springboot.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRun implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("项目启动完毕了 。。。。Start........");
    }
}
