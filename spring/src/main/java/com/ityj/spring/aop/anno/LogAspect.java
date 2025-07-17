package com.ityj.spring.aop.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before(value = "execution (public int com.ityj.spring.aop.service.impl.CalculatorImpl.*(int, int))")
    public void before(JoinPoint joinPoint) {
        System.out.println("@Before前置通知...");
    }

    @AfterReturning(value = "execution (public int com.ityj.spring.aop.service.impl.CalculatorImpl.*(int, int))", returning = "res")
    public void afterReturning(JoinPoint joinPoint, Object res) {
        System.out.println("@AfterReturning 后置通知... " + res);
    }

    @AfterThrowing(value = "execution (public int com.ityj.spring.aop.service.impl.CalculatorImpl.*(int, int))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("@AfterThrowing 异常通知..." + ex);
    }

    @After(value = "pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("@After后置通知...");
    }

    @Around(value = "execution (public int com.ityj.spring.aop.service.impl.CalculatorImpl.*(int, int))")
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

    @Pointcut("execution (public int com.ityj.spring.aop.service.impl.CalculatorImpl.*(..))")
    public void pointcut(){}

}
