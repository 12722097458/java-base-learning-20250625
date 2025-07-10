package com.ityj.advance.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    public void testReflect () throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // Class的实例对应着加载到内存中的一个运行时类
        Class clazz = Person.class;
        Class clazz2 = new Person().getClass();
        Class clazz3 = Class.forName("com.ityj.advance.reflect.entity.Person");
        Class clazz4 = MethodTest.class.getClassLoader().loadClass("com.ityj.advance.reflect.entity.Person");
        System.out.println(clazz == clazz2);  // true
        System.out.println(clazz3 == clazz4); // true
        System.out.println(clazz == clazz3);  // true


        Object object = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("eat", String.class);
        method.setAccessible(true);
        Object retValue = method.invoke(object, "香蕉");
        System.out.println("retValue = " + retValue);

        Method method1 = clazz.getDeclaredMethod("setName", String.class);
        method1.setAccessible(true);
        method1.invoke(object, "Jack");
        System.out.println("object.getClass() = " + object.getClass());
        System.out.println("object = " + object);

        Method method2 = clazz.getDeclaredMethod("getName");
        Object name = method2.invoke(object);
        System.out.println("name = " + name);

        Method[] methods = clazz.getMethods();  // 返回Person以及其父类 Object的所有public方法
        System.out.println("Arrays.toString(methods) = " + Arrays.toString(methods));

        Method[] declaredMethods = clazz.getDeclaredMethods();  // 只返回java.lang.String com.ityj.advance.reflect.entity.Person里的所有方法（包括private）
        System.out.println("Arrays.toString(declaredMethods) = " + Arrays.toString(declaredMethods));

    }
}

class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void eat(String food) {
        System.out.println("吃的是：" + food);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}