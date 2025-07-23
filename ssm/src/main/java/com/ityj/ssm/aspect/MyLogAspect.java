package com.ityj.ssm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class MyLogAspect {

    @Pointcut("execution(public * com.ityj.ssm.controller.HelloController.*(..))")
    private void pt() {
    }

    @Before(value = "pt()")
    public void before(JoinPoint joinPoint) {
        System.out.println("MyLogAspect.before...");
    }

    @After(value = "pt()")
    public void after(JoinPoint joinPoint) {
        System.out.println("MyLogAspect.after...");
    }

    @AfterReturning(value = "pt()", returning = "res")
    public Object afterReturning(JoinPoint joinPoint, Object res) {
        System.out.println("MyLogAspect.afterReturning...");
        return res;
    }

    @AfterThrowing(value = "pt()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("MyLogAspect.afterThrowing..." + ex);
    }

    @Around(value = "pt()")
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
}
