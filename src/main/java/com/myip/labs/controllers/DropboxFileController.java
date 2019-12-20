package com.myip.labs.controllers;

import com.myip.labs.entity.File;
import com.myip.labs.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class DropboxFileController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public List<File> findAll(){
        return fileService.findAll();
    }

    @PostMapping("/save/{adId}")
    public ResponseEntity<File> handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable  Integer adId){
        File savedFile = fileService.save(file, adId).orElse(null);
        return ResponseEntity.ok(savedFile);
    }
}
