package com.ityj.servlet.cookiesession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/session1")
public class SessionServlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into SessionServlet1.service()...");

        // 会判断JSESSIONID作为key的Cookie是否存在， 不存在则创建
            // 存在会判断当前会话的JSESSIONID是否存在， 不存在则创建
        HttpSession session = req.getSession();
        System.out.println(session.getId() + "-------------" + session.isNew());
        Object user = session.getAttribute("user");
        if (user == null) {
            System.out.println("user is null");
            session.setAttribute("user", "Jack");
        } else {
            System.out.println("user is " + user);
        }
    }
}
