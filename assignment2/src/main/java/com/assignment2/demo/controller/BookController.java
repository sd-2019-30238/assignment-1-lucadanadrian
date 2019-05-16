package com.assignment2.demo.controller;

import com.assignment2.demo.model.Book;
import com.assignment2.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ModelAndView addBook(Book book) {
        ModelAndView modelAndView = new ModelAndView("insertBookPage");
        bookService.addBook(book);
        return modelAndView;
    }

    @GetMapping("/addBook")
    public ModelAndView displayInsertBookPage() {
        ModelAndView modelAndView = new ModelAndView("insertBookPage");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @GetMapping("/books")
    public ModelAndView displayAllBooks() {
        ModelAndView modelAndView = new ModelAndView("seeAllBooks");
        modelAndView.addObject("books", bookService.seeAllBooks());
        return modelAndView;
    }

    @GetMapping("/books/author")
    public ModelAndView selectBookByAuthor(@RequestParam(value = "author") String author) {
        ModelAndView modelAndView = new ModelAndView("seeBooksByAuthor");
        modelAndView.addObject("booksByAuthor", bookService.seeBooksByAuthor(author));
        return modelAndView;
    }

    @GetMapping("/books/title")
    public ModelAndView selectBookByTitle(@RequestParam(value = "title") String title) {
        ModelAndView modelAndView = new ModelAndView("seeBooksByTitle");
        modelAndView.addObject("booksByTitle", bookService.seeBooksByTitle(title));
        return modelAndView;
    }

    @GetMapping("/books/genre")
    public ModelAndView selectBooksByGenre(@RequestParam(value="genre") String genre){
        ModelAndView modelAndView = new ModelAndView("seeBooksByGenre");
        modelAndView.addObject("booksByGenre",bookService.seeBooksByGenre(genre));
        return modelAndView;
    }

    @GetMapping("/books/year")
    public ModelAndView selectBooksByYear(@RequestParam(value = "year") int year){
        ModelAndView modelAndView = new ModelAndView("seeBooksByYear");
        modelAndView.addObject("booksByYear", bookService.seeBooksByRelease(year));
        return modelAndView;
    }

    @DeleteMapping("/books/{id}")
    public ModelAndView deleteBook(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/books");
        bookService.deleteBook((int) id);
        return modelAndView;
    }

    @GetMapping("/booksU")
    public ModelAndView displayBooksForUsers(){
        ModelAndView modelAndView = new ModelAndView("booksSeenByUsers");
        modelAndView.addObject("booksSeenByUsers",bookService.seeAllBooks());
        return modelAndView;
    }

    @PostMapping("/booksU/{id}")
    public ModelAndView orderBook(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/booksU");
        bookService.orderBook(id);
        return modelAndView;
    }

}
