package com.ityj.springboot.controller;

import com.ityj.springboot.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello ....");
        return "Hello";
    }

    @GetMapping("/student")
    public Student testContentNegotiation(@RequestHeader("Accept") String accept) {
        System.out.println("testContentNegotiation .... accept : " + accept);
        Student student = new Student();
        student.setAge(33);
        student.setHeight(182);
        student.setName("Jack2");
        student.setGender("男");
        student.setBirthday(new Date(System.currentTimeMillis()));
        return student;
    }
}
