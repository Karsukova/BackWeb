package com.myip.labs.repository;

import com.myip.labs.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {
    List<Ad> findAllById(Integer id);

   // Object createAd(int i, String s, String s1, String s2, String s3, int i1);
}
