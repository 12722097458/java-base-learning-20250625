package com.ityj.springboot.aop.service.impl;

import com.ityj.springboot.aop.service.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("CalculatorImpl.add  -- 进入目标方法");
//        int aa = 1 / 0;
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        System.out.println("CalculatorImpl.minus");
        return a - b;
    }
}
