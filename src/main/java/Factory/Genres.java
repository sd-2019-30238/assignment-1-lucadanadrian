package Factory;

import connection.Connection;
import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Genres implements Recommendations {
    @Override
    public Book getRecommendtation() {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
        BookDAO books = appContext.getBean("bookDAO",BookDAO.class);
        books.selectAll();
        return null;
    }
}
