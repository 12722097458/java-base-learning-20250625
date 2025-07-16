package com.ityj.spring.resource.controller;

import com.ityj.spring.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("resourceUserController")
public class UserController {

    @Resource
    private UserService userService;

    public void add() {
        System.out.println("resourceUserController.add()...");
        userService.add();
    }


}
