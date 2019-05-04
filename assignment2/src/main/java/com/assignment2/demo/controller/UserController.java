package com.assignment2.demo.controller;

import com.assignment2.demo.model.User;
import com.assignment2.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ModelAndView addUser(User user){
        ModelAndView modelAndView = new ModelAndView("loginPage");
        userService.addUser(user);
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView displaySignUpPage(){
        ModelAndView modelAndView = new ModelAndView("signupPage");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView displayAllUsers(){
        ModelAndView modelAndView = new ModelAndView("seeAllUsers");
        modelAndView.addObject("users",userService.seeAllUsers());
        return modelAndView;
    }

//    @DeleteMapping("/users")
//    public ModelAndView deleteUser(){
//        ModelAndView modelAndView = new ModelAndView("seeAllUsers");
//    }
}
