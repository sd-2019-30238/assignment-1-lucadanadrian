package com.books.assignment3.mediator;

import com.books.assignment3.handler.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mediator {
    @Autowired
    private List<RequestHandler> requestHandlers;


}
