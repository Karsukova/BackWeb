package com.myip.labs.service;

import com.myip.labs.entity.Ad;
import com.myip.labs.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdService {
    @Autowired
    private final AdRepository adRepository;

    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public void createAd(Ad ad){
        adRepository.save(ad);
    }
    public List<Ad> findAllById(Integer id){
        return adRepository.findAllById(id);
    }
}
