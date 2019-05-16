package Factory;

import bll.BookBLL;
import connection.Connection;
import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Trends implements Recommendations{
    BookBLL books = new BookBLL();
    @Override
    public List<Book> getRecommendtation() {
        int maxim= books.selectAllBooks().get(0).getNumberOfBooks();

        for(Book b: books.selectAllBooks()){
            if(b.getNumberOfBooks() > maxim){
                maxim = b.getNumberOfBooks();
            }
        }

        return books.selectBooksByNumber(maxim);
    }
}
