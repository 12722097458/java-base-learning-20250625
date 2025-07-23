package com.ityj.ssm.controller;

import lombok.experimental.PackagePrivate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Test
    public void testAspect() {
        String ping = helloController.ping();
        System.out.println("ping = " + ping);
    }


}