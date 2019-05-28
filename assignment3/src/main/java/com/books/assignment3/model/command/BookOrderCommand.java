package com.books.assignment3.model.command;

import com.books.assignment3.model.query.BookQuery;
import com.books.assignment3.model.query.UserQuery;

public class BookOrderCommand {
    private UserQuery user;
    private BookQuery book;

    public BookOrderCommand(){

    }

    public BookOrderCommand(UserQuery user, BookQuery book) {
        this.user = user;
        this.book = book;
    }

    public UserQuery getUser() {
        return user;
    }

    public void setUser(UserQuery user) {
        this.user = user;
    }

    public BookQuery getBook() {
        return book;
    }

    public void setBook(BookQuery book) {
        this.book = book;
    }
}
