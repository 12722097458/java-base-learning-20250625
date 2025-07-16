package com.ityj.spring.aop.staticproxy;

import com.ityj.spring.aop.service.Calculator;
import com.ityj.spring.aop.service.impl.CalculatorImpl;

public class ProxyCalculator implements Calculator {

    private Calculator calculator;


    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public ProxyCalculator() {
    }

    @Override
    public int add(int a, int b) {
        System.out.println("ProxyCalculator.add....before");
        int res = calculator.add(a, b);
        System.out.println("ProxyCalculator.add....end");
        return res;
    }

    @Override
    public int minus(int a, int b) {
        System.out.println("ProxyCalculator.minus....before");
        int res = calculator.minus(a, b);
        System.out.println("ProxyCalculator.minus....end");
        return res;
    }
}
