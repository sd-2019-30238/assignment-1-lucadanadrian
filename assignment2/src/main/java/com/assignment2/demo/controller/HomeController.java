package com.assignment2.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ModelAndView displayHomePage(){
        ModelAndView modelAndViewv = new ModelAndView("mainMenu");
        return modelAndViewv;
    }
}
