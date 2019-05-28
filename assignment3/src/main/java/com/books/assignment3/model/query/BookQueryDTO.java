package com.books.assignment3.model.query;

public class BookQueryDTO {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int releaseDate;
    private int numberOfBooks;

    public BookQueryDTO() {

    }

    public BookQueryDTO(int id, String title, String author, String genre, int releaseDate, int numberOfBooks) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.numberOfBooks = numberOfBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
