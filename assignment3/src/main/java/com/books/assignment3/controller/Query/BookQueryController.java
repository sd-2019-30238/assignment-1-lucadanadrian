package com.books.assignment3.controller.Query;

import com.books.assignment3.model.query.BookQueryDTO;
import com.books.assignment3.service.query.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookQueryController {
    @Autowired
    private BookQueryService bookQueryService;

    @GetMapping("/books")
    public ModelAndView displayAllBooks() {
        ModelAndView modelAndView = new ModelAndView("seeAllBooks");
        modelAndView.addObject("books", bookQueryService.seeAllBooks());
        return modelAndView;
    }

    @GetMapping("/addBook")
    public ModelAndView displayInsertBookPage() {
        ModelAndView modelAndView = new ModelAndView("insertBookPage");
        modelAndView.addObject("book", new BookQueryDTO());
        return modelAndView;
    }

    @GetMapping("/booksU")
    public ModelAndView displayBooksForUsers() {
        ModelAndView modelAndView = new ModelAndView("booksSeenByUsers");
        modelAndView.addObject("booksSeenByUsers", bookQueryService.seeAllBooks());
        return modelAndView;
    }


}
