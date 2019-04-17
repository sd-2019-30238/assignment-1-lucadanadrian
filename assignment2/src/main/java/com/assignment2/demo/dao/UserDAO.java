package com.assignment2.demo.dao;

import com.assignment2.demo.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public  User selectById(int id){
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> selectAll(){
        return (List<User>) sessionFactory.getCurrentSession().createSQLQuery("Select * from user").addEntity(User.class).list();
    }

    public void insertTable(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateTable(User user){
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public void deleteFromTable(int id){
        sessionFactory.getCurrentSession().createSQLQuery("Delete from user where user_id = :id")
                .setParameter("id",id).executeUpdate();
    }
}
