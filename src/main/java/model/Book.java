package model;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="book_title")
    private String title;
    @Column(name="book_author")
    private String author;
    @Column(name="book_genre")
    private String genre;
    @Column(name="book_releasedate")
    private String releaseDate;
    @Column(name="book_price")
    private int price;
    @Column(name="book_number")
    private int numberOfBooks;

    public Book(){}

    public Book(int id, String title, String author, String genre, String releaseDate, int price, int numberOfBooks) {
        Id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.numberOfBooks=numberOfBooks;
    }

    public int getId(){ return Id; }

    public void setId(int id){ Id = id; }

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfBooks(){
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks){
        this.numberOfBooks = numberOfBooks;
    }

    @Override
    public String toString() {
        return "Book: " +
//                "Id=" + Id +
                " title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                ", numberOfBooks=" + numberOfBooks +'\n';
    }
}
