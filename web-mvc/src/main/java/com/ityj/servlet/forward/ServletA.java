package com.ityj.servlet.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


// response  HTTP/1.1 200

/*
*
*   1. 请求转发是通过HttpServletRequest实现的
*   2. 是服务器内部行为，对客户端是屏蔽的
*   3. 客户端只产生了一个请求， 服务端只产生了一对request和response.
*   4. 客户端请求栏地址是不变的
*   5. 参数可以传递
*   6. 目标资源可以是servlet动态资源，也可以是html等静态资源
*   7. 目标资源可以是WEB-INF下的受保护的资源，该方式也是获取WEB-INF资源的唯一途径
*   8. 目标资源不可以是外部资源
*
* */
@WebServlet(urlPatterns = "/servletA")
public class ServletA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into ServletA.service()...");

        // req.getRequestDispatcher("servletB").forward(req, resp);
        //req.getRequestDispatcher("index.jsp").forward(req, resp);
        //req.getRequestDispatcher("WEB-INF/css/a.css").forward(req, resp); 可以访问
        req.getRequestDispatcher("https://www.baidu.com").forward(req, resp); // 消息 请求的资源[/web_mvc/www.baidu.com]不可用



    }
}
