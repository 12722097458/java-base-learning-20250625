package com.ityj.advance.reflect;

import com.ityj.controller.HelloController;
import org.junit.jupiter.api.Test;

public class ClassLoaderTest {


    @Test
    public void classLoaderTest() {
        ClassLoader classLoader = HelloController.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);  // jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83

        ClassLoader classLoader2 = classLoader.getParent();
        System.out.println("classLoader2 = " + classLoader2);  // jdk.internal.loader.ClassLoaders$PlatformClassLoader@1810399e


        // 表示方式：JVM 规范规定，由启动类加载器加载的类，其 Class.getClassLoader() 方法必须返回 null。
        // 这是一种约定，用于标识这些类的“根”来源。
        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println("classLoader3 = " + classLoader3); // null
    }



}
