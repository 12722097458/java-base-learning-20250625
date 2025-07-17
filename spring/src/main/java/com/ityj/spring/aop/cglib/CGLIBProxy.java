package com.ityj.spring.aop.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy {
    public static void main(String[] args) {
        // 导出生成的代理字节码文件
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "outclass/");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AccountService.class);  // 设置目标类为父类
        enhancer.setCallback(new CglibInterceptor()); // 设置拦截器
        AccountService proxy = (AccountService) enhancer.create();  // 创建代理实例
        proxy.add();
    }
}


// 普通方法(非接口)
class AccountService {
    public void add() {
        System.out.println("AccountService.add");
    }
}

class CglibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibInterceptor.intercept  前置增强");
        Object res = methodProxy.invokeSuper(o, args);
        System.out.println("CglibInterceptor.intercept  后置增强");
        return res;
    }
}
