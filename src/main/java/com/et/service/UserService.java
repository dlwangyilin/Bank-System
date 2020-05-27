package com.et.service;


import com.et.entity.User;
import com.et.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);

    void save(User theUser);


    List<User> getUsers();

    void saveUser(User theUser);

    User getUser(int id);

    void deleteUser(int id);

    List<User> searchUsers(String theSearchName);

}
