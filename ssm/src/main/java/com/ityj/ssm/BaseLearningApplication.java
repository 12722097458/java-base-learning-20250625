package com.ityj.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableTransactionManagement // 开启事务管理
public class BaseLearningApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(BaseLearningApplication.class, args);
        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {

            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        Object student = ioc.getBean("student");  // org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(java.lang.String, boolean)
        System.out.println("student = " + student);


    }

}
