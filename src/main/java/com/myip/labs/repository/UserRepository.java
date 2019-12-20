package com.myip.labs.repository;

import com.myip.labs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllById(Integer user_id);

    User findUserByUsername(String username);
}
