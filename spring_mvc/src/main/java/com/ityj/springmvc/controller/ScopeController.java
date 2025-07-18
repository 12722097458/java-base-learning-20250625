package com.ityj.springmvc.controller;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/scope")
public class ScopeController {

    // 原始Servlet获取参数
    @GetMapping(value = "/requestApi")
    public String testServlet(HttpServletRequest  request) {
        request.setAttribute("money", "333");
        return "hello";
    }

    @GetMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("money_mv", "888");

        return mv;
    }

    @GetMapping(value = "/testModel")
    public String testModel(Model model) {
        System.out.println(model.getClass().getName());  // org.springframework.validation.support.BindingAwareModelMap
       model.addAttribute("money_model", "009");
        return "hello";
    }

    @GetMapping(value = "/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());   // org.springframework.validation.support.BindingAwareModelMap
        map.put("money_map", "777");
        return "hello";
    }

    @GetMapping(value = "/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        System.out.println(modelMap.getClass().getName());  // org.springframework.validation.support.BindingAwareModelMap
        modelMap.addAttribute("money_modelMap", "1234");
        return "hello";
    }

    @GetMapping(value = "/testSessionScope")
    public String testSessionScope(HttpSession session) {
        session.setAttribute("sessionScope", "sessionScope");
        return "hello";
    }

    @GetMapping(value = "/testServletContextScope")
    public String testServletContextScope(HttpSession session) {
        ServletContext app = session.getServletContext();
        app.setAttribute("testServletContextScope", "testServletContextScope");
        return "hello";
    }

}
