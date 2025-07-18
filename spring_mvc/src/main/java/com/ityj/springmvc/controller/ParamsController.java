package com.ityj.springmvc.controller;


import com.ityj.springmvc.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/param")
public class ParamsController {

    // 原始Servlet获取参数
    @GetMapping(value = "/testServlet")
    public String testServlet(HttpServletRequest  request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        System.out.println("username:"+username);
        return "hello";
    }

    @RequestMapping(value = "/testParam")
    public String testParam(@RequestParam(value = "username", defaultValue = "default", required = true) String username,
                            @RequestParam("hobby") List<String> hobby,
                            @RequestHeader("Host") String host,
                            @CookieValue(value = "JSESSIONID") String jsessionId,
                            User user) {
        System.out.println("username = " + username);
        System.out.println("hobby = " + hobby);
        System.out.println("host = " + host);
        System.out.println("jsessionId = " + jsessionId);
        System.out.println("user = " + user);
        return "hello";
    }

}
