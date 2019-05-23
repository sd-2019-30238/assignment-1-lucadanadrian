package com.assignment2.demo.dao;

import com.assignment2.demo.model.BookRequestObserver;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRequestDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public BookRequestDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public BookRequestObserver selectById(int id) {
        return sessionFactory.getCurrentSession().get(BookRequestObserver.class, id);
    }

    public List<BookRequestObserver> selectAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + BookRequestObserver.class.getName()).list();
    }

    public void insert(BookRequestObserver bookRequestObserver) {
        sessionFactory.getCurrentSession().save(bookRequestObserver);
    }

    public void delete(BookRequestObserver bookRequestObserver) {
        sessionFactory.getCurrentSession().delete(bookRequestObserver);
    }
}
