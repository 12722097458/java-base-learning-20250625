package com.ityj.servlet.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


// 第一个response
// HTTP/1.1 302
//Location: WEB-INF/css/a.css

/*
*
*   1. 请求转发是通过HttpServletResponse实现的
*   2. 是在服务器提示下，客户端行为
*   3. 客户端产生了多个请求  >=2，同时也会有多对req, resp
*   4. 客户端请求栏地址是变化的
*   5. 参数不可以传递
*   6. 目标资源可以是servlet动态资源，也可以是html等静态资源(视图资源)
*   7. 不可以是WEB-INF下的受保护的资源
*   8. 目标资源可以是外部资源
*
* */
@WebServlet(urlPatterns = "/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into Servlet1.service()...");

        // sendRedirect 两个作用 1.status code 302  2.  Location: servlet2
        //resp.sendRedirect("servlet2");
        //resp.sendRedirect("/servlet2");  // http://localhost:8080/servlet2
        resp.sendRedirect("/web_mvc/servlet2");  // 重定向 绝对路径需要加contextName
        //resp.sendRedirect("index.jsp");
        //resp.sendRedirect("WEB-INF/css/a.css"); // 不能访问。 相当于想通过浏览器直接访问WEB-INF  拒绝
        //resp.sendRedirect("https://www.baidu.com"); // 可用

    }
}
