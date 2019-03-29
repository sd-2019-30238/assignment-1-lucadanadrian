package bll;

import connection.Connection;
import dao.BookDAO;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BookBLL {
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
    BookDAO books = appContext.getBean("bookDAO",BookDAO.class);

    public BookBLL(){
    }
    public Book selectBookById(int id){
        return books.selectById(id);
    }

    public List<Book> selectAllBooks(){
        return books.selectAll();
    }

    public List<Book> selectBookByAuthor(String author){
        return books.selectByAuthor(author);
    }

    public List<Book> selectBookByTitle(String title){
        return books.selectByTitle(title);
    }
    public List<Book> selectBookByYear(int year){
        return books.selectByDate(year);
    }
    public List<Book> selectBookByGenre(String genre){
        return books.selectByGenre(genre);
    }
    public void insertBook(Book book){
        books.insertTable(book);
    }
    public void updateBook(Book book){
        books.updateTable(book);
    }
    public void deleteBook(int id){
        books.deleteFromTable(id);
    }
}
