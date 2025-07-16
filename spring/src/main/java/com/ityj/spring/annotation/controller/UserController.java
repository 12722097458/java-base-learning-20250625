package com.ityj.spring.annotation.controller;

import com.ityj.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // 1.成员变量
    /*@Autowired  byType
    private UserService userService;*/

    /*// 2. set方法
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    // 3. 构造方法上
    /*private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    // 4. 构造方法的形参上
    /*private UserService userService;
    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }*/

    // 5. 当前方法只有一个只含一个变量的构造方法， 可以省略@Autowired
    /*private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    // 6 Autowired + Qualifier
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    public void add() {
        System.out.println("UserController.add()...");
        userService.add();
    }


}
