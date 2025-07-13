package com.ityj.advance.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        Man man = new Man();
        Human proxy = (Human) ProxyFactory.newInstance(man);
        String retValue = proxy.eat("土豆");
        System.out.println("retValue = " + retValue);

    }
}


interface Human {
    String eat(String food);
}

class Man implements Human {
    @Override
    public String eat(String food) {
        System.out.println("Man 正在吃" + food);
        return food;
    }
}

class ProxyFactory {
    public static Object newInstance(Object obj) {
        //     public static Object newProxyInstance(ClassLoader loader,
        //                                          Class<?>[] interfaces,
        //                                          InvocationHandler h) {
        Object object = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(System.currentTimeMillis());
                Object retValue = method.invoke(obj, args);
                System.out.println(System.currentTimeMillis());
                return retValue;
            }
        });
        return object;
    }


}
