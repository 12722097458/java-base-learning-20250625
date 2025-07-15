package com.ityj.servlet.cookiesession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/coo/cookie1")
public class CookieServlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into CookieServlet1.service()...");
        Cookie cookie =  new Cookie("k1", "v1");
        cookie.setMaxAge(3 * 60); // second
        Cookie cookie2 =  new Cookie("k2", "v2");
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
    }
}
