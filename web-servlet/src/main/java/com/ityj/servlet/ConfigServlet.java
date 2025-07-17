package com.ityj.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ConfigServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into service()...");
        ServletConfig servletConfig = getServletConfig();
        String value = servletConfig.getInitParameter("key1");
        System.out.println("key1:" + value);

        ServletContext servletContext = getServletContext();
        String unicode = servletContext.getInitParameter("unicode");
        System.out.println("ServletContext - unicode:" + unicode);


        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("success!");
    }
}
