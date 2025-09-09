package com.ityj.springboot.component;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class StartupListener implements SpringApplicationRunListener {

    // CommandLineRunners and ApplicationRunners have not been called.
    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("项目启动完毕了 。。。。SpringApplicationRunListener.started()........");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("项目启动完毕了 。。。。SpringApplicationRunListener.ready()........");
    }
}
