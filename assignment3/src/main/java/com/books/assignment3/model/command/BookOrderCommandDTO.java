package com.books.assignment3.model.command;

import com.books.assignment3.model.query.BookQueryDTO;
import com.books.assignment3.model.query.UserQueryDTO;

public class BookOrderCommandDTO {
    private UserQueryDTO user;
    private BookQueryDTO book;

    public BookOrderCommandDTO(){

    }

    public BookOrderCommandDTO(UserQueryDTO user, BookQueryDTO book) {
        this.user = user;
        this.book = book;
    }

    public UserQueryDTO getUser() {
        return user;
    }

    public void setUser(UserQueryDTO user) {
        this.user = user;
    }

    public BookQueryDTO getBook() {
        return book;
    }

    public void setBook(BookQueryDTO book) {
        this.book = book;
    }
}
