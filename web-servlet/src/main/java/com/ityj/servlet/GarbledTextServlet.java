package com.ityj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// todo
@WebServlet(value = "/garbled", loadOnStartup = 11)
public class GarbledTextServlet extends HttpServlet {

    public GarbledTextServlet() {
        System.out.println("GarbledTextServlet  constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("GarbledTextServlet.init()");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
/*
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");*/

        System.out.println(req.getParameter("name"));
        resp.getWriter().write(req.getParameter("name"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        System.out.println(req.getParameter("name"));
        resp.getWriter().write(req.getParameter("name"));
    }
}
