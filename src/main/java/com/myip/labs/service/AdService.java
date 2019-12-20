package com.myip.labs.service;

import com.myip.labs.dto.AdDTO;

import java.util.List;

public interface AdService{
    List<AdDTO> findAll();
    void createAd(AdDTO ad);
    void delete(Integer id);
    List<AdDTO> findByTextContainingIgnoreCase(String title);
    }
