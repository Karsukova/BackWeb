package com.myip.labs.service;

import com.myip.labs.dto.PocketDTO;
import com.myip.labs.entity.User;

import java.util.List;

public interface PocketService {

    void save(PocketDTO pocket, User user);
    void delete(Integer id, User user);
    List<PocketDTO> findAllByUser(User user);
    List<PocketDTO> findAll();
    void createPocket(PocketDTO pocket, User user);
}