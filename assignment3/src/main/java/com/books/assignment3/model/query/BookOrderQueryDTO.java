package com.books.assignment3.model.query;

import com.books.assignment3.model.database.Book;
import com.books.assignment3.model.database.User;

public class BookOrderQueryDTO {
    private int id;
    private User user;
    private Book book;

    public BookOrderQueryDTO() {

    }

    public BookOrderQueryDTO(int id, User user, Book book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
