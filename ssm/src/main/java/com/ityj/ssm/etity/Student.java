package com.ityj.ssm.etity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
    private Dog dog;

    public Student() {
        System.out.println("Student无参构造。。。");
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        System.out.println("set方法执行了。。。");
        this.dog = dog;
    }

    private void initMethod() {
        System.out.println("Student @Bean initMethod。。。");

    }

    private void destroyMethod() {
        System.out.println("Student @Bean destroyMethod。。。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean...destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy");
    }

}
