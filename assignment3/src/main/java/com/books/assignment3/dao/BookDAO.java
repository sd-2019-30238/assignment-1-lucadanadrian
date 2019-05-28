package com.books.assignment3.dao;

import com.books.assignment3.model.database.Book;
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

    public List<Book> selectByDate(int year){
        return sessionFactory.getCurrentSession().createSQLQuery("Select * from book where book_releaseyear = " + year).addEntity(Book.class).list();
    }

    public List<Book> selectByNumberOfBooks(int numberOfBooks){
        return sessionFactory.getCurrentSession().createSQLQuery("select * from book where book_quantity =" + numberOfBooks).addEntity(Book.class).list();
    }

    public List<Book> selectByAuthor(String author){
        return sessionFactory.getCurrentSession().createSQLQuery("Select * from book where book_author = '" + author+"'").addEntity(Book.class).list();
    }

    public List<Book> selectByTitle(String title){
        return  sessionFactory.getCurrentSession().createSQLQuery("Select * from book where book_title ='" +title +"'").addEntity(Book.class).list();
    }

    public List<Book> selectByGenre(String genre){
        return sessionFactory.getCurrentSession().createSQLQuery("Select * from book where book_genre = '"+genre+"'").addEntity(Book.class).list();
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
