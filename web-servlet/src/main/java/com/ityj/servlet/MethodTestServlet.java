package com.ityj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/methodTestServlet")
public class MethodTestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        testHttpServletRequest(req);
        testHttpServletResponse(resp);
    }


    private void testHttpServletRequest(HttpServletRequest req) {
        // 请求行  GET /web_mvc/lifeCycleServlet HTTP/1.1
        System.out.println(req.getMethod());
        System.out.println(req.getContextPath());
        System.out.println(req.getProtocol());
        // 请求头  k:v
        System.out.println(req.getHeader("Connection"));
        // 请求体
        String k = req.getParameter("k");
        System.out.println("k = " + k);
    }


    private void testHttpServletResponse(HttpServletResponse resp) throws IOException {
        // 响应行  HTTP/1.1 200
        resp.setStatus(200);
        // 响应头
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Connection", "keep-alive");  // Connection: keep-alive, keep-alive
        // 响应体
        PrintWriter writer = resp.getWriter();
        writer.write("<b>complete</b>");
    }

}
