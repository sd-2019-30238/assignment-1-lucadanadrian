package com.books.assignment3.handler.impl;

import com.books.assignment3.handler.RequestHandler;
import com.books.assignment3.request.Request;
import com.books.assignment3.service.command.BookCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDeleteRequestHandler implements RequestHandler {

    @Autowired
    BookCommandService bookCommandService;

    @Override
    public void handleRequest(Request request) {
        int id = (int) request.getRequestObject();
        bookCommandService.deleteBook(id);
    }
}
