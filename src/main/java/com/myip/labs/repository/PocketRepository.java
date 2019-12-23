package com.myip.labs.repository;

import com.myip.labs.entity.Pocket;
import com.myip.labs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, Integer> {
    List<Pocket> findAllByUser(User user);
}
