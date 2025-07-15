package com.ityj.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/*")
public class UserController extends BaseController{

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add...");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("complete....");
    }

}
