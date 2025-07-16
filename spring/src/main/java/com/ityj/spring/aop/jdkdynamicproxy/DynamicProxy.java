package com.ityj.spring.aop.jdkdynamicproxy;

import com.ityj.spring.aop.service.Calculator;
import com.ityj.spring.aop.service.impl.CalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static Object createInstance(Object obj) {
        Object instance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                Object invoke = method.invoke(obj, args);
                System.out.println("after...");
                return invoke;
            }
        });
        return instance;
    }


    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        Calculator instance = (Calculator) DynamicProxy.createInstance(calculator);
        int add = instance.add(1, 2);
        System.out.println("add = " + add);
        int minus = instance.minus(1, 2);
        System.out.println("minus = " + minus);
    }

}
