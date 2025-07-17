package com.ityj.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class LogXmlAspect {

    public void before(JoinPoint joinPoint) {
        System.out.println("@Before前置通知...");
    }

    public void afterReturning(JoinPoint joinPoint, Object res) {
        System.out.println("@AfterReturning 后置通知... " + res);
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("@AfterThrowing 异常通知..." + ex);
    }

    public void after(JoinPoint joinPoint) {
        System.out.println("@After后置通知...");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = null;
        try {
            System.out.println("@Around环绕通知 前...");
            proceed = joinPoint.proceed();
            System.out.println("@Around环绕通知 afterReturning...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("@Around环绕通知 catch 异常...");
        } finally {
            System.out.println("@Around环绕通知 后...");
        }
        return proceed;
    }

    public void pointcut(){}

}
