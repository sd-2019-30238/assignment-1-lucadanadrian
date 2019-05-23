package com.assignment2.demo.service;

import com.assignment2.demo.model.AppUserDetails;
import com.assignment2.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LogInService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.selectUserByEmail(s);
        if (user == null) {
            return null;
        }
        AppUserDetails userDetail = new AppUserDetails(user);
        return userDetail;
    }
}
