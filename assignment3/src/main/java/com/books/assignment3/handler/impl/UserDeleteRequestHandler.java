package com.books.assignment3.handler.impl;

import com.books.assignment3.handler.RequestHandler;
import com.books.assignment3.request.Request;
import com.books.assignment3.service.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteRequestHandler implements RequestHandler {
    @Autowired
    private UserCommandService userCommandService;

    @Override
    public void handleRequest(Request request) {
        int id = (int) request.getRequestObject();
        userCommandService.deleteUser(id);
    }
}
