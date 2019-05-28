package com.books.assignment3.service.query;

import com.books.assignment3.dao.UserDAO;
import com.books.assignment3.model.database.User;
import com.books.assignment3.model.query.UserQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserQueryService {
    @Autowired
    private UserDAO userDAO;

    public UserQueryService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserQueryDTO> seeAllUsers(){
        List<UserQueryDTO> usersDTO = new ArrayList<>();
        List<User> users = userDAO.selectAll();
        for(User user:users){
            UserQueryDTO aux = new UserQueryDTO();
            aux.setEmail(user.getEmail());
            aux.setFirstName(user.getFirstName());
            aux.setLastName(user.getLastName());
            aux.setPassword(user.getPassword());
            aux.setSubscribed(user.getSubscribed());
            aux.setSubscriptionMonth(user.getSubscriptionMonths());
            usersDTO.add(aux);
        }
        return usersDTO;
    }

    public UserQueryDTO selectUserByEmail(String email){
        User user = userDAO.selectByEmail(email);
       return new UserQueryDTO(user.getId(),user.getEmail(),user.getLastName(),user.getFirstName(),user.getPassword(),user.getSubscriptionMonths(),user.getSubscribed());
    }
}
