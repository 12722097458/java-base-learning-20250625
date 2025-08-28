package com.ityj.springmvc.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class HelloController {

    // method is GET, and must contains parameter name=Jack
    @RequestMapping(value = "/hello", method = RequestMethod.GET, params = {"name=Jack"})
    public String hello() {
        System.out.println("hello");
//        int a = 1/0;
        return "hello";
    }

    // ? 代表任意一个字符  特殊字符不行 ? / :都不行
//    @GetMapping(value = "/a?a")
    // * 代表0个或多个
//    @GetMapping(value = "/a*a")
    // **  表示任意的一层或多层目录  只能放在最后
    @GetMapping(value = "/asd/**")
    public String ant() {
        System.out.println("ant");
        return "hello";
    }

    @GetMapping(value = "/hello/{id}/{name}")
    public String pathVariable(@PathVariable(value = "id") String id, @PathVariable("name") String name) {
        log.info("你好：id={}, name={}", id, name);
        return "hello";
    }

}
