package com.myip.labs.controllers;

import com.myip.labs.entity.User;
import com.myip.labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }
    // Создать запись
    @PostMapping("/registration")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("Saved");
    }
}
