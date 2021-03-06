package com.books.assignment3.dao;

import com.books.assignment3.model.database.BookOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public BookOrder selectByOrderId(int id) {
        return sessionFactory.getCurrentSession().get(BookOrder.class, id);
    }

    public List<BookOrder> selecOrders() {
        return (List<BookOrder>) sessionFactory.getCurrentSession().createSQLQuery("Select * from bookorder").addEntity(BookOrder.class).list();
    }

    public List<BookOrder> selectOrdersByUsersEmail(String email) {
        return sessionFactory.getCurrentSession().createQuery("from " + BookOrder.class.getName() + " b where b.user.email =:email").setParameter("email", email).list();
    }

    public void insertOrder(BookOrder order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void updateOrder(BookOrder order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    public void deleteOrder(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("Delete From bookorder where order_id = :id").setParameter("id", id).executeUpdate();
    }
}
