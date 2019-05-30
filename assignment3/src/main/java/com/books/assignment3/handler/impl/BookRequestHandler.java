package com.books.assignment3.handler.impl;

import com.books.assignment3.handler.RequestHandler;
import com.books.assignment3.model.command.BookCommandDTO;
import com.books.assignment3.request.Request;
import com.books.assignment3.service.command.BookCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookRequestHandler implements RequestHandler {
    @Autowired
    private BookCommandService bookCommandService;

//    @Autowired
//    public BookRequestHandler(BookCommandService bookCommandService){
//        this.bookCommandService=bookCommandService;
//    }

    @Override
    public void handleRequest(Request request) {
        BookCommandDTO bookCommandDTO = new BookCommandDTO();
        bookCommandDTO.setTitle(((BookCommandDTO) request.getRequestObject()).getTitle());
        bookCommandDTO.setAuthor(((BookCommandDTO) request.getRequestObject()).getAuthor());
        bookCommandDTO.setGenre(((BookCommandDTO) request.getRequestObject()).getGenre());
        bookCommandDTO.setReleaseDate(((BookCommandDTO) request.getRequestObject()).getReleaseDate());
        bookCommandDTO.setPrice(((BookCommandDTO) request.getRequestObject()).getPrice());
        bookCommandDTO.setNumberOfBooks(((BookCommandDTO) request.getRequestObject()).getNumberOfBooks());
        bookCommandService.addBook(bookCommandDTO);
    }
}
