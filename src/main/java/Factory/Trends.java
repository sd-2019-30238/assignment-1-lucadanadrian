package Factory;

import connection.Connection;
import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Trends implements Recommendations{
    @Override
    public Book getRecommendtation() {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Connection.class);
        BookDAO books = appContext.getBean("bookDAO",BookDAO.class);
        Book newestBook =null;
        int maxim= books.selectAll().get(0).getNumberOfBooks();
        for(Book b: books.selectAll()){
            if(b.getNumberOfBooks() > maxim){
                maxim = b.getNumberOfBooks();
            }
        }
        for(Book b: books.selectAll()){
            if(b.getNumberOfBooks() == maxim){
                newestBook = b;
            }
        }
        return newestBook;
    }
    public static void main(String[] args){
        Trends t = new Trends();
        System.out.println(t.getRecommendtation().toString());
    }
}
