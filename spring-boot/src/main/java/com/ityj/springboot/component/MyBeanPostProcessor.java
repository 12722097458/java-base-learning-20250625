package com.ityj.springboot.component;

import com.ityj.springboot.controller.HelloController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (HelloController.class.equals(bean.getClass())) {
            // 执行方法
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization ..." + beanName);
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
