package com.myip.labs.service;

import com.myip.labs.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void createUser(User user);

    List<User> findAll();
}
