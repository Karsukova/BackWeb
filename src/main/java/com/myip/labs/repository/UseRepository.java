package com.myip.labs.repository;

import com.myip.labs.entity.Use;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseRepository extends JpaRepository<Use, Integer> {
    List<Use> findAllById(Integer user_id);
}
