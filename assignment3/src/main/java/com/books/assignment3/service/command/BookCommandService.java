package com.books.assignment3.service.command;

import com.books.assignment3.dao.BookDAO;
import com.books.assignment3.dao.OrderDAO;
import com.books.assignment3.model.command.BookCommandDTO;
import com.books.assignment3.model.command.BookOrderCommandDTO;
import com.books.assignment3.model.database.Book;
import com.books.assignment3.model.database.BookOrder;
import com.books.assignment3.model.database.User;
import com.books.assignment3.model.query.UserQueryDTO;
import com.books.assignment3.service.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class BookCommandService {
    private BookDAO bookDAO;
    private UserQueryService userQueryService;
    private OrderDAO orderDAO;

    @Autowired
    public BookCommandService(BookDAO bookDAO, UserQueryService userQueryService, OrderDAO orderDAO) {
        this.bookDAO = bookDAO;
        this.userQueryService = userQueryService;
        this.orderDAO = orderDAO;
    }

    public void addBook(BookCommandDTO bookCommandDTO) {
        Book book = new Book();
        book.setTitle(bookCommandDTO.getTitle());
        book.setAuthor(bookCommandDTO.getAuthor());
        book.setGenre(bookCommandDTO.getGenre());
        book.setPrice(bookCommandDTO.getPrice());
        book.setReleaseDate(bookCommandDTO.getReleaseDate());
        book.setNumberOfBooks(bookCommandDTO.getNumberOfBooks());
        bookDAO.insertTable(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteFromTable(id);
    }

    public void orderBook(int id, String email) {
        Book book = bookDAO.selectById(id);
        UserQueryDTO userQueryDTO = userQueryService.selectUserByEmail(email);
        User user = new User();
        user.setEmail(userQueryDTO.getEmail());
        user.setFirstName(userQueryDTO.getFirstName());
        user.setLastName(userQueryDTO.getLastName());
        user.setPassword(userQueryDTO.getPassword());
        user.setSubscribed(userQueryDTO.getSubscribed());
        user.setSubscriptionMonths(userQueryDTO.getSubscriptionMonth());

        if (book.getNumberOfBooks() > 0) {
            book.setNumberOfBooks(book.getNumberOfBooks() - 1);
            bookDAO.updateTable(book);
            orderDAO.insertOrder(new BookOrder(0, user, book, 0));
        } else {
//            observerService.addObserver(book, user);
            book.setNumberOfBooks(0);
            bookDAO.updateTable(book);
        }
    }

    public void returnBook(int bookOrderId) {
        BookOrder bookOrder = orderDAO.selectByOrderId(bookOrderId);
        Book book = bookDAO.selectById(bookOrder.getBook().getId());
        book.setNumberOfBooks(book.getNumberOfBooks() + 1);
//        observerService.notifyObservers(book);
        bookDAO.updateTable(book);
        orderDAO.deleteOrder(bookOrderId);
    }

}
