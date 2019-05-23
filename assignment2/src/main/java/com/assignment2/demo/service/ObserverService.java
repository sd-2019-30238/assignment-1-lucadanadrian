package com.assignment2.demo.service;

import com.assignment2.demo.dao.BookRequestDAO;
import com.assignment2.demo.model.Book;
import com.assignment2.demo.model.BookRequestObserver;
import com.assignment2.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ObserverService {
    @Autowired
    private BookRequestDAO bookRequestDAO;
    @Autowired
    private EmailService emailService;

    public void notifyObservers(Book observable) {
        for (BookRequestObserver bookRequestObserver : observable.getBookRequestObservers()) {
            User user = bookRequestObserver.getUser();
            emailService.sendSimpleMessage(user.getEmail(), "Book released", "Book " + observable.getTitle() + " has been released!");
            bookRequestDAO.delete(bookRequestObserver);
        }
    }

    public void addObserver(Book observable, User observer) {
        bookRequestDAO.insert(new BookRequestObserver(observer, observable));
    }
}
