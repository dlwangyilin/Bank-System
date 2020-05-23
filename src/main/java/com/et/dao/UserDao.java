package com.et.dao;

import com.et.entity.User;

import java.util.List;
public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);

    void saveUser(User theUser);

    List<User> getUsers();

    User getUser(int id);

    void deleteUser(int id);

    List<User> searchUsers(String theSearchName);

    
}
