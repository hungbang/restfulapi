package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String errorPage(ModelAndView model){
//        model.addObject("errorMess", "404 not found");
//        model.setViewName("error");
        System.out.println("this is error page");
        return "error";
    }
}
