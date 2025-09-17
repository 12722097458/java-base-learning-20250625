package com.ityj.spring.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ityj.spring.annotation")  // 组件扫描 <context:component-scan base-package="com.ityj.spring.annotation"/>
public class MyConfiguration {

}
