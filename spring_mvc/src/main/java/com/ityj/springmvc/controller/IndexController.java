package com.ityj.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "index";
    }

    @GetMapping("/err")
    public String errorTest() {
        String string = null;
        int res = string.length();
        return "index";
    }
}
