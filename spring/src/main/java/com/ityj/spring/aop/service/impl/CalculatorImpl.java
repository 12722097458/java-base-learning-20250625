package com.ityj.spring.aop.service.impl;

import com.ityj.spring.aop.service.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("CalculatorImpl.add");
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        System.out.println("CalculatorImpl.minus");
        return a - b;
    }
}
