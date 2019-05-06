package com.assignment2.demo.service;

import com.assignment2.demo.dao.UserDAO;
import com.assignment2.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void addUser(User user) {
        userDAO.insertTable(user);
    }

    public List<User> seeAllUsers(){
        return userDAO.selectAll();
    }

    public void deleteUser(int id){
        userDAO.deleteFromTable(id);
    }

    public void accpetUser(int id){
        User user = userDAO.selectById(id);
        user.setSubscribed("subbed");
        userDAO.updateTable(user);
    }
}
