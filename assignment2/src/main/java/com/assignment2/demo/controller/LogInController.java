package com.assignment2.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LogInController {
    @GetMapping
    public ModelAndView showLogIn(){
        return new ModelAndView("logIn");
    }
}
