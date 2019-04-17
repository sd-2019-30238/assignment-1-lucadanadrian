package com.assignment2.demo.service;

import com.assignment2.demo.dao.BookDAO;
import com.assignment2.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;
    public void addBook(Book book){
        bookDAO.insertTable(book);
    }
}
