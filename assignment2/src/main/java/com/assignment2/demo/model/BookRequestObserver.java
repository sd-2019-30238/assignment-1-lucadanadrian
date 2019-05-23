package com.assignment2.demo.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
public class BookRequestObserver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Book book;

    public BookRequestObserver() {
    }


    public BookRequestObserver(User user, Book book) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequestObserver that = (BookRequestObserver) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
