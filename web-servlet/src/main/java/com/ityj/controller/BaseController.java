package com.ityj.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

// 可以根据方法名，组装请求路径。实现一个servlet有多个请求   /user/*  --> /user/add   /user/query
public class BaseController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BaseController.service()...");
        String requestURI = req.getRequestURI();
        String[] splitArr = requestURI.split("\\/");
        String methodName = splitArr[splitArr.length - 1];
        System.out.println("uri is : " + requestURI);
        System.out.println("methodName is : " + methodName);
        Class clazz = this.getClass();
        System.out.println("clazz = " + clazz);
        Method declaredMethod = null;
        try {
            declaredMethod = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("BaseController.service() end...");
    }
}
