package com.books.assignment3.handler.impl;

import com.books.assignment3.handler.RequestHandler;
import com.books.assignment3.model.command.UserCommandDTO;
import com.books.assignment3.model.database.User;
import com.books.assignment3.request.Request;
import com.books.assignment3.service.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequestHandler implements RequestHandler {
    @Autowired
    private UserCommandService userCommandService;

    @Override
    public void handleRequest(Request request) {
        UserCommandDTO userCommandDTO = new UserCommandDTO();
        userCommandDTO.setEmail(((UserCommandDTO) request.getRequestObject()).getEmail());
        userCommandDTO.setLastName(((UserCommandDTO) request.getRequestObject()).getLastName());
        userCommandDTO.setFirstName(((UserCommandDTO) request.getRequestObject()).getFirstName());
        userCommandDTO.setPassword(((UserCommandDTO) request.getRequestObject()).getPassword());
        userCommandDTO.setSubscriptionMonth(((UserCommandDTO) request.getRequestObject()).getSubscriptionMonth());
        userCommandDTO.setSubscribed(((UserCommandDTO) request.getRequestObject()).getSubscribed());
        userCommandService.addUser(userCommandDTO);
    }
}
