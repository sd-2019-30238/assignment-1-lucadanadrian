package com.assignment2.demo.controller;

import com.assignment2.demo.model.User;
import com.assignment2.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ModelAndView addUser(User user){
        ModelAndView modelAndView = new ModelAndView("signupPage");
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

    @DeleteMapping("/users/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/users");
        userService.deleteUser(id);
        return modelAndView;
    }

    @PostMapping("/users/{id}")
    public ModelAndView acceptUser(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/users");
        userService.acceptUser(id);
        return modelAndView;
    }
    @GetMapping("/login")
    public ModelAndView showLogIn() {
        ModelAndView modelAndView = new ModelAndView("loginPage");
//        modelAndView.addObject("user", userService.logInUser(email));
//        @RequestParam(required = false, value = "email") String email
        return modelAndView;
    }
}
