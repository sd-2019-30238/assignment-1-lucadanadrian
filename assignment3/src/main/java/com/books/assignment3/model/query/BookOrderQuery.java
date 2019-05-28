package com.books.assignment3.model.query;

public class BookOrderQuery {
    private int id;
    private UserQuery user;
    private BookQuery book;

    public BookOrderQuery() {

    }

    public BookOrderQuery(int id, UserQuery user, BookQuery book) {
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
