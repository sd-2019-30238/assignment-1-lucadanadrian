package com.assignment2.demo.controller;

import com.assignment2.demo.service.BookService;
import com.assignment2.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookOrderController {
    private OrderService orderService;
    private BookService bookService;

    @Autowired
    public BookOrderController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/bookOrders/currentUser")
    public ModelAndView getOrdersForAuthenticatedUser(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("seeOrders");
        modelAndView.addObject("bookOrders", orderService.getOrdersForAnUserByEmail(authentication.getName()));
        return modelAndView;
    }

    @PostMapping("/booksU/{id}")
    public ModelAndView orderBook(@PathVariable("id") int id, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("redirect:/booksU");
        bookService.orderBook(id, authentication.getName());
        return modelAndView;
    }

    @PutMapping("/booksU/return")
    public ModelAndView returnBook(@RequestParam("orderId") int orderId, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("redirect:/bookOrders/currentUser");

        bookService.returnBook(orderId);
        return modelAndView;
    }
}
