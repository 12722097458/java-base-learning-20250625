package com.ityj.spring.aop.staticproxy;

import com.ityj.spring.aop.service.impl.CalculatorImpl;

public class TestCalculator {

    public static void main(String[] args) {

        CalculatorImpl calculator = new CalculatorImpl();
        ProxyCalculator proxyCalculator = new ProxyCalculator(calculator);
        int add = proxyCalculator.add(1, 2);
        System.out.println("add = " + add);
    }

}
