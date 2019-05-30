package com.books.assignment3.service.command;

import com.books.assignment3.model.database.AppUserDetails;
import com.books.assignment3.model.database.User;
import com.books.assignment3.model.query.UserQueryDTO;
import com.books.assignment3.service.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LogInService implements UserDetailsService {
    @Autowired
    private UserQueryService userQueryService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userQueryDTO = userQueryService.selectUserByEmail(s);
        if (userQueryDTO == null) {
            return null;
        }
        AppUserDetails userDetail = new AppUserDetails(userQueryDTO);
        return userDetail;
    }

}
