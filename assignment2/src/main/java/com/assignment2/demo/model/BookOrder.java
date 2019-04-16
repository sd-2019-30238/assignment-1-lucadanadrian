package com.assignment2.demo.model;

import javax.persistence.*;

@Entity
@Table
public class BookOrder {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;
    @ManyToOne
    @JoinColumn(name="book")
    private Book book;
    @Column(name="book_quantity")
    private int bookNumber;

    public BookOrder(){

    }

    public BookOrder(int id, User user, Book book,int bookNumber) {
        Id = id;
        this.user = user;
        this.book = book;
        this.bookNumber=bookNumber;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "Id=" + Id +
                ", userID=" + user +
                ", bookID=" + book +
                ", bookNumber=" + bookNumber +
                '}'+'\n';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }
}

