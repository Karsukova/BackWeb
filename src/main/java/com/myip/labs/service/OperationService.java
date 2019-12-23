package com.myip.labs.service;

import com.myip.labs.dto.OperationDTO;
import com.myip.labs.entity.Pocket;

import java.util.List;

public interface OperationService {
    List<OperationDTO> findAll();
    void createOperation(OperationDTO operation, Pocket pocket);
    void delete(Integer id);
    List<OperationDTO> findByTextContainingIgnoreCase(String text);
    }
