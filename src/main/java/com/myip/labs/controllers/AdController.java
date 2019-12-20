package com.myip.labs.controllers;

import com.myip.labs.dto.AdDTO;
import com.myip.labs.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AdController {
    @Autowired
    AdService adService;
    // Получить все записи
    @GetMapping("/ad")
    public List<AdDTO> getAllNotes(){
        return adService.findAll();
    }
    // Создать запись
    @PostMapping("/ad")
    public ResponseEntity<String> createAd(@Valid @RequestBody AdDTO ad) {
        adService.createAd(ad);
        return ResponseEntity.ok("Saved");
    }


    // Удалить запись по id
    @DeleteMapping("/ad/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") Integer id) {
        adService.delete(id);
        return ResponseEntity.ok("Deleted");

    }
    @GetMapping("/search")
    public List<AdDTO> searchByText(@RequestParam("text") String text) {
        return adService.findByTextContainingIgnoreCase(text);
    }
}
