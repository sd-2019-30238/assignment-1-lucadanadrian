package com.assignment2.demo.service;

import com.assignment2.demo.dao.BookDAO;
import com.assignment2.demo.dao.BookRequestDAO;
import com.assignment2.demo.dao.OrderDAO;
import com.assignment2.demo.model.Book;
import com.assignment2.demo.model.BookOrder;
import com.assignment2.demo.model.BookRequest;
import com.assignment2.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookService {
    private BookDAO bookDAO;
    private BookRequestDAO bookRequestDAO;
    private UserService userService;
    private OrderDAO orderDAO;

    @Autowired
    public BookService(BookDAO bookDAO, BookRequestDAO bookRequestDAO, UserService userService, OrderDAO orderDAO) {
        this.bookDAO = bookDAO;
        this.bookRequestDAO = bookRequestDAO;
        this.userService = userService;
        this.orderDAO = orderDAO;
    }

    public void addBook(Book book) {
        bookDAO.insertTable(book);
    }

    public List<Book> seeAllBooks() {
        return bookDAO.selectAll();
    }

    public List<Book> seeBooksByAuthor(String author) {
        return bookDAO.selectByAuthor(author);
    }

    public List<Book> seeBooksByRelease(int year) {
        return bookDAO.selectByDate(year);
    }

    public List<Book> seeBooksByTitle(String title) {
        return bookDAO.selectByTitle(title);
    }

    public List<Book> seeBooksByGenre(String genre) {
        return bookDAO.selectByGenre(genre);
    }

    public void deleteBook(int id) {
        bookDAO.deleteFromTable(id);
    }

    public void orderBook(int id) {
        Book book = bookDAO.selectById(id);
        User user = userService.selectUserByEmail("E");
        if (book.getNumberOfBooks() > 0) {
            book.setNumberOfBooks(book.getNumberOfBooks() - 1);
            bookDAO.updateTable(book);
            orderDAO.insertOrder(new BookOrder(0, user, book, 1));
        } else {
            bookRequestDAO.insert(new BookRequest(user, book));
            book.setNumberOfBooks(0);
            bookDAO.updateTable(book);
        }
    }

//    public void orderBook(int id, String email) {
//        Book book = bookDAO.selectById(id);
//        User user = userService.selectUserByEmail(email);
//        if (book.getNumberOfBooks() > 0) {
//            book.setNumberOfBooks(book.getNumberOfBooks() - 1);
//            bookDAO.updateTable(book);
//            orderDAO.insertOrder(new BookOrder(0, user, book, 1));
//        } else {
//            bookRequestDAO.insert(new BookRequest(user, book));
//            book.setNumberOfBooks(0);
//            bookDAO.updateTable(book);
//        }
//    }

    public void returnBook(int bookOrderId) {
        BookOrder bookOrder = orderDAO.selectByOrderId(bookOrderId);
        Book book = bookDAO.selectById(bookOrder.getBook().getId());
        book.setNumberOfBooks(book.getNumberOfBooks() + 1);
        User user = null;
        if (!book.getBookRequests().isEmpty()) {
            for (BookRequest bookRequest : book.getBookRequests()) {
                user = bookRequest.getUser();
                //TODO notify user
                System.out.println("notify " + user.getEmail());
            }
        }
        bookDAO.updateTable(book);
        orderDAO.deleteOrder(bookOrderId);
    }
}
