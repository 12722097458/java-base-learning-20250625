package com.ityj.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    @GetMapping("/user/{id}")
    public String query(@PathVariable("id") String id) {
        System.out.println("query id is: " + id);
        return "success";
    }

    @PostMapping("/user")
    public String add(@RequestParam("id") String id, @RequestParam("username") String username) {
        System.out.println("add id is: " + id + ". name is : " + username);
        return "success";
    }

    @PutMapping("/user")
    public String update(@RequestParam("id") String id, @RequestParam("newName") String newName) {
        System.out.println("update id is: " + id + ". newName is : " + newName);
        return "success";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") String id) {
        System.out.println("delete id is: " + id);
        return "success";
    }



}
