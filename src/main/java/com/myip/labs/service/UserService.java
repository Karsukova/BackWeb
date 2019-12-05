package com.myip.labs.service;

import com.myip.labs.entity.Use;
import com.myip.labs.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UseRepository userRepository;

    public UserService(UseRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(Use use){
        userRepository.save(use);
    }
    public List<Use> findAllById(Integer id){
        return userRepository.findAllById(id);
    }
}