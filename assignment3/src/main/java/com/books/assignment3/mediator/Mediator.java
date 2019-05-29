package com.books.assignment3.mediator;

import com.books.assignment3.handler.RequestHandler;
import com.books.assignment3.request.Request;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Mediator {
    @Autowired
    private List<RequestHandler> requestHandlers;


}
