package com.books.assignment3.controller.Command;

import com.books.assignment3.mediator.Mediator;
import com.books.assignment3.model.command.UserCommandDTO;
import com.books.assignment3.request.Request;
import com.books.assignment3.service.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserCommandController {
    @Autowired
    private UserCommandService userCommandService;
    @Autowired
    private Mediator mediator;

    @PostMapping("/signUp")
    public ModelAndView addUser(UserCommandDTO userCommandDTO) {
        ModelAndView modelAndView = new ModelAndView("signupPage");
        mediator.handleRequests(new Request("addUser", userCommandDTO));
        return modelAndView;
    }

    @DeleteMapping("/users/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users");
//        userCommandService.deleteUser(id);
        mediator.handleRequests(new Request("deleteUser", id));
        return modelAndView;
    }

    @PostMapping("/users/{id}")
    public ModelAndView acceptUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users");
        mediator.handleRequests(new Request("acceptUser", id));
//        userCommandService.acceptUser(id);
        return modelAndView;
    }
}
