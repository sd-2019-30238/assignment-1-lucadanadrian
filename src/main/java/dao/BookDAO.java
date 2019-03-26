package dao;

import model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Book selectById(int id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    public List<Book> selectAll() {
        return (List<Book>) sessionFactory.getCurrentSession().createSQLQuery("Select * from book").addEntity(Book.class).list();
    }

    public void insertTable(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    public void updateTable(Book book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
    }

    public void deleteFromTable(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("Delete From book where book_id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
