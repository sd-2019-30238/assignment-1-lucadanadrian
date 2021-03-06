package com.books.assignment3.controller.Command;

import com.books.assignment3.mediator.Mediator;
import com.books.assignment3.model.command.BookCommandDTO;
import com.books.assignment3.request.Request;
import com.books.assignment3.service.command.BookCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookCommandController {
    @Autowired
    private Mediator mediator;
    @Autowired
    private BookCommandService bookCommandService;

    @DeleteMapping("/books/{id}")
    public ModelAndView deleteBook(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/books");
        mediator.handleRequests(new Request("deleteBook",(int) id));
        return modelAndView;
    }

    @PostMapping("/addBook")
    public ModelAndView addBook(BookCommandDTO bookCommandDTO) {
        ModelAndView modelAndView = new ModelAndView("insertBookPage");
        mediator.handleRequests(new Request("addBook",bookCommandDTO));
        return modelAndView;
    }

}
