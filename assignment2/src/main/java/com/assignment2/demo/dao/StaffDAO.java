package com.assignment2.demo.dao;

import com.assignment2.demo.model.Staff;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class StaffDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Staff selectStaffById(int id){
        return sessionFactory.getCurrentSession().get(Staff.class,id);
    }

    public List<Staff> selectAll(){
        return sessionFactory.getCurrentSession().createSQLQuery("Select * from staff").addEntity(Staff.class).list();
    }

    public void insertStaff(Staff staff){
        sessionFactory.getCurrentSession().save(staff);
    }

    public void updateStaff(Staff staff){
        sessionFactory.getCurrentSession().saveOrUpdate(staff);
    }

    public void deleteStaff(int id){
        sessionFactory.getCurrentSession().createSQLQuery("Delete from staff where staff_id =:id ").setParameter("id",id).executeUpdate();
    }

}
