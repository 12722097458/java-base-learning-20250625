package com.ityj.servlet.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/servletB")
public class ServletB extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into ServletB.service()...");

        String k = req.getParameter("k");
        System.out.println("k from input parameter: " + k);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("ServletB success!");
    }
}
