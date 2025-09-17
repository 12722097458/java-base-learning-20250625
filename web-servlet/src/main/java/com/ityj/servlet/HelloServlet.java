package com.ityj.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/helloServlet", loadOnStartup = -1,
initParams = {@WebInitParam(name = "k", value = "v"), @WebInitParam(name = "k2", value = "v2")})
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into HelloServlet.service()...");

        getServletContext().setAttribute("k", "v"); // test Listener--MyContextListener

        ServletConfig servletConfig = this.getServletConfig();
        String k2 = servletConfig.getInitParameter("k2");
        System.out.println("k2 = " + k2);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("success!");
    }
}
