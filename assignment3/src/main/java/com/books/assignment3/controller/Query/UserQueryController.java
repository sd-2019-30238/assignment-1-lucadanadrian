package com.books.assignment3.controller.Query;

import com.books.assignment3.model.command.UserCommandDTO;
import com.books.assignment3.service.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserQueryController {
    @Autowired
    private UserQueryService userQueryService;

    @GetMapping("/signUp")
    public ModelAndView displaySignUpPage() {
        ModelAndView modelAndView = new ModelAndView("signupPage");
        modelAndView.addObject("userCommandDTO", new UserCommandDTO());
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView displayAllUsers() {
        ModelAndView modelAndView = new ModelAndView("seeAllUsers");
        modelAndView.addObject("users", userQueryService.seeAllUsers());
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
