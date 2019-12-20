package com.myip.labs.service;

import com.myip.labs.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FileService {
    List<File> findAll();
    Optional<File> save(MultipartFile file, Integer user);
}
