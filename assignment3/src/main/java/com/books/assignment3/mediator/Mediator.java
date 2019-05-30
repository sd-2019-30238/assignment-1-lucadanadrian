package com.books.assignment3.mediator;

import com.books.assignment3.handler.RequestHandler;
import com.books.assignment3.handler.impl.*;
import com.books.assignment3.model.command.BookCommandDTO;
import com.books.assignment3.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mediator {
    private BookRequestHandler bookRequestHandler;
    private UserRequestHandler userRequestHandler;
    private BookDeleteRequestHandler bookDeleteRequestHandler;
    private UserDeleteRequestHandler userDeleteRequestHandler;
    private UserAcceptanceRequestHandler userAcceptanceRequestHandler;

    @Autowired
    public Mediator(BookRequestHandler bookRequestHandler, UserRequestHandler userRequestHandler, BookDeleteRequestHandler bookDeleteRequestHandler, UserDeleteRequestHandler userDeleteRequestHandler, UserAcceptanceRequestHandler userAcceptanceRequestHandler) {
        this.bookRequestHandler = bookRequestHandler;
        this.userRequestHandler = userRequestHandler;
        this.bookDeleteRequestHandler = bookDeleteRequestHandler;
        this.userDeleteRequestHandler = userDeleteRequestHandler;
        this.userAcceptanceRequestHandler = userAcceptanceRequestHandler;
    }

    public void handleRequests(Request request) {
        if (request.getRequestName().equals("addBook")) {
            bookRequestHandler.handleRequest(request);
        }
        if (request.getRequestName().equals("addUser")) {
            userRequestHandler.handleRequest(request);
        }
        if (request.getRequestName().equals("deleteBook")) {
            bookDeleteRequestHandler.handleRequest(request);
        }
        if (request.getRequestName().equals("deleteUser")) {
            userDeleteRequestHandler.handleRequest(request);
        }
        if (request.getRequestName().equals("acceptUser")) {
            userAcceptanceRequestHandler.handleRequest(request);
        }
    }

}
