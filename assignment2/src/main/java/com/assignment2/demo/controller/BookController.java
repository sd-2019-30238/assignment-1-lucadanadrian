package com.assignment2.demo.controller;

import com.assignment2.demo.model.Book;
import com.assignment2.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ModelAndView addBook(Book book){
        ModelAndView modelAndView = new ModelAndView("mainMenu");
        bookService.addBook(book);
        return modelAndView;
    }

    @GetMapping("/addBook")
    public ModelAndView displaySignUpPage(){
        ModelAndView modelAndView = new ModelAndView("insertBookPage");
        modelAndView.addObject("book",new Book());
        return modelAndView;
    }
}
