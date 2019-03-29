package Factory;

import bll.BookBLL;
import connection.Connection;
import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Genres implements Recommendations {
    BookBLL books = new BookBLL();

    @Override
    public List<Book> getRecommendtation() {
        List<String> genres = new ArrayList<>();

        for (Book b : books.selectAllBooks()) {
            genres.add(b.getGenre());
        }
        int randomGenreIndex = new Random().nextInt(genres.size());
        String gen = genres.get(randomGenreIndex);

        return books.selectBookByGenre(gen);
    }
}
