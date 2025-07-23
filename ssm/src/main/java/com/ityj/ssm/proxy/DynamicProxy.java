package com.ityj.ssm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static Object getProxyInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("DynamicProxy.before..." + method.getName());
                Object invoke = method.invoke(obj, args);
                System.out.println("DynamicProxy.after..." + method.getName());
                return invoke;
            }
        });
    }
}

interface Calculator {
    int add(int a, int b);
}

class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("CalculatorImpl.add()...");
        return a + b;
    }
}

class TestDynamicProxy {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        Calculator proxyInstance = (Calculator) DynamicProxy.getProxyInstance(calculator);
        int add = proxyInstance.add(1, 5);
        System.out.println("add = " + add);

    }
}