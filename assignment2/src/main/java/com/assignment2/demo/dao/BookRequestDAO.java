package com.assignment2.demo.dao;

import com.assignment2.demo.model.BookRequest;
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

    public BookRequest selectById(int id) {
        return sessionFactory.getCurrentSession().get(BookRequest.class, id);
    }

    public List<BookRequest> selectAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + BookRequest.class.getName()).list();
    }

    public void insert(BookRequest bookRequest) {
        sessionFactory.getCurrentSession().save(bookRequest);
    }

    public void delete(BookRequest bookRequest) {
        sessionFactory.getCurrentSession().delete(bookRequest);
    }
}
