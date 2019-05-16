package com.assignment2.demo.service;

import com.assignment2.demo.dao.BookDAO;
import com.assignment2.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public void addBook(Book book) {
        bookDAO.insertTable(book);
    }

    public List<Book> seeAllBooks() {
        return bookDAO.selectAll();
    }

    public List<Book> seeBooksByAuthor(String author){
        return bookDAO.selectByAuthor(author);
    }

    public List<Book> seeBooksByRelease(int year){
        return bookDAO.selectByDate(year);
    }

    public List<Book> seeBooksByTitle(String title){
        return bookDAO.selectByTitle(title);
    }

    public List<Book> seeBooksByGenre(String genre){
        return bookDAO.selectByGenre(genre);
    }

    public void deleteBook(int id){
        bookDAO.deleteFromTable(id);
    }

    public void orderBook(int id){
        Book book = bookDAO.selectById(id);
        if(book.getNumberOfBooks()>0) {
            book.setNumberOfBooks(book.getNumberOfBooks()-1);
            bookDAO.updateTable(book);
        }else{
            book.setNumberOfBooks(0);
            bookDAO.updateTable(book);
        }
    }
}
