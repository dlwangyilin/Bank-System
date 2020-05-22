package com.et.dao;

import com.et.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
