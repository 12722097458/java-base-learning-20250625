package com.ityj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/lifeCycleServlet", loadOnStartup = 22)
public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("LifeCycleServlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into LifeCycleServlet.service()...");

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("success!");
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleServlet destroy");
    }
}
