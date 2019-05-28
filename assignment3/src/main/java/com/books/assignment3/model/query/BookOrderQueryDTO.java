package com.books.assignment3.model.query;

public class BookOrderQueryDTO {
    private int id;
    private UserQueryDTO user;
    private BookQueryDTO book;

    public BookOrderQueryDTO() {

    }

    public BookOrderQueryDTO(int id, UserQueryDTO user, BookQueryDTO book) {
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
