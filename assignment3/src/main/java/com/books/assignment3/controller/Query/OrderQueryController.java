package com.books.assignment3.controller.Query;

import com.books.assignment3.service.query.OrderQueryService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderQueryController {
    private OrderQueryService orderQueryService;

    @Autowired
    public OrderQueryController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @GetMapping("/bookOrders/currentUser")
    public ModelAndView getOrdersForAuthenticatedUser(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("seeOrders");
        modelAndView.addObject("bookOrders", orderQueryService.getOrdersForAnUserByEmail(authentication.name()));
        return modelAndView;
    }
}


