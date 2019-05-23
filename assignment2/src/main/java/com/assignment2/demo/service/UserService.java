package com.assignment2.demo.service;

import com.assignment2.demo.dao.UserDAO;
import com.assignment2.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.insertTable(user);
    }

    public List<User> seeAllUsers() {
        return userDAO.selectAll();
    }

    public User selectUserByEmail(String email) {
        return userDAO.selectByEmail(email);
    }

    public void deleteUser(int id) {
        userDAO.deleteFromTable(id);
    }

    public void acceptUser(int id) {
        User user = userDAO.selectById(id);
        user.setSubscribed("subbed");
        userDAO.updateTable(user);
    }

}
