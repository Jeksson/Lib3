package com.jekss.config;

import com.jekss.controller.config.SecurityUser;
import com.jekss.entities.User;
import com.jekss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * Created by Жека on 22.07.2015.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException("UserName "+s+" not found");
        }
        return new SecurityUser(user);
    }
}
