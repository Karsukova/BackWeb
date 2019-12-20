package com.myip.labs.repository;

import com.myip.labs.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {
    List<Ad> findByTextContainingIgnoreCase(String text);
}
