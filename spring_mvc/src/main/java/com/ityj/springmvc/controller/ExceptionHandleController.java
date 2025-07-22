package com.ityj.springmvc.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler({NullPointerException.class})
    public String fileNotFound(Model model, Exception e) {
        System.out.println("fileNotFound");
        model.addAttribute("errMsg", e);
        return "error";
    }


}
