package com.books.assignment3.model.command;

public class BookCommandDTO {
    private String title;
    private String author;
    private String genre;
    private int releaseDate;
    private int price;
    private int numberOfBooks;

    public BookCommandDTO() {

    }

    public BookCommandDTO(String title, String author, String genre, int releaseDate, int price, int numberOfBooks) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.numberOfBooks = numberOfBooks;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
