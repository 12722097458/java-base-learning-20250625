package com.ityj.springmvc.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(("/view"))
public class ViewController {

    @RequestMapping(value = "/thymeleaf")
    public String thymeleaf() {
        System.out.println("thymeleaf");
        return "hello";   // ThymeleafViewResolver
    }

    // 请求转发
    @RequestMapping(value = "/testForward")
    public String testForward() {
        System.out.println("testForward");
        return "forward:/view/thymeleaf";   // InternalResourceView
    }

    @RequestMapping(value = "/testRedirect")
    public String testRedirect() {
        System.out.println("testRedirect");
        return "redirect:/view/testForward";   // RedirectView
    }

}
