package com.assignment2.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "book_title", nullable = false)
    private String title;
    @Column(name = "book_author", nullable = false)
    private String author;
    @Column(name = "book_genre")
    private String genre;
    @Column(name = "book_releaseyear")
    private int releaseDate;
    @Column(name = "book_price", nullable = false)
    private int price;
    @Column(name = "book_quantity", nullable = false)
    private int numberOfBooks;

    @OneToMany(mappedBy = "book")
    private List<BookRequest> bookRequests = new ArrayList<>();

    public Book() {
    }

    public Book(int id, String title, String author, String genre, int releaseDate, int price, int numberOfBooks) {
        Id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.numberOfBooks = numberOfBooks;
    }

    public Book(String title, String author, String genre, int releaseDate, int price, int numberOfBooks) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.numberOfBooks = numberOfBooks;
    }

    public List<BookRequest> getBookRequests() {
        return bookRequests;
    }

    public void setBookRequests(List<BookRequest> bookRequests) {
        this.bookRequests = bookRequests;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    @Override
    public String toString() {
        return "Book: " +
                "Id=" + Id +
                " Title= " + title +
                ", Author= " + author +
                ", Genre= " + genre +
                ", Release Year= " + releaseDate +
                ", Price=" + price +
                ", Number Of Books=" + numberOfBooks + '\n';
    }
}
