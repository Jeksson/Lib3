package com.jekss.dao;

import com.jekss.entities.User;

import java.util.List;

/**
 * Created by Жека on 21.07.2015.
 */
public interface UserDao {

    public List<User> findAll();

    public User createAndRedact(User user);

    public User findUserById(int id);

    public User login(String email, String password);
}
