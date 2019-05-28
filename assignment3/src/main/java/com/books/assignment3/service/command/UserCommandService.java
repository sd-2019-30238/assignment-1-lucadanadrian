package com.books.assignment3.service.command;

import com.books.assignment3.dao.UserDAO;
import com.books.assignment3.model.command.UserCommandDTO;
import com.books.assignment3.model.database.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCommandService {
    @Autowired
    private UserDAO userDAO;

    public void addUser(UserCommandDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setLastName(dto.getLastName());
        user.setFirstName(dto.getFirstName());
        user.setPassword(dto.getPassword());
        user.setSubscriptionMonths(dto.getSubscriptionMonth());
        user.setSubscribed(dto.getSubscribed());
        userDAO.insertTable(user);
    }

    public void deleteUser(int id){
        userDAO.deleteFromTable(id);
    }

    public void acceptUser(int id){
        User user = userDAO.selectById(id);
        user.setSubscribed("subbed");
        userDAO.updateTable(user);
    }
}
