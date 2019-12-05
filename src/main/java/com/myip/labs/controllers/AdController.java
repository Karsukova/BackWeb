package com.myip.labs.controllers;

import com.myip.labs.entity.Ad;
import com.myip.labs.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AdController {
    @Autowired
    AdRepository adRepository;
    // Получить все записи
    @GetMapping("/ad")
    public List getAllNotes() {
        return adRepository.findAll();
    }
    // Создать запись
    @PostMapping("/ad")
    public Ad createAd(@Valid @RequestBody Ad ad) {
        return adRepository.save(ad);
    }
    // Получить запись по id
    @GetMapping("/ad/{id}")
    public Ad getNoteById(@PathVariable(value = "id") Integer adId) throws Exception {
        return adRepository.findById(adId)
                .orElseThrow(() -> new Exception());
    }
    // Обновить запись
    @PutMapping("/ad/{id}")
    public Ad updateNote(@PathVariable(value = "id") Integer adId,
                           @Valid @RequestBody Ad adDetails) throws Exception {

        Ad ad = adRepository.findById(adId)
                .orElseThrow(() -> new Exception());

        ad.setTopic(adDetails.getTopic());
        ad.setPrice(adDetails.getPrice());
        ad.setText(adDetails.getText());
        ad.setTelnum(adDetails.getTelnum());
        ad.setUse(adDetails.getUse());

        Ad updatedAd = adRepository.save(ad);
        return updatedAd;
    }
    // Удалить запись по id
    @DeleteMapping("/ad/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Integer adId) throws Exception {
        Ad ad = adRepository.findById(adId)
                .orElseThrow(() -> new Exception());

        adRepository.delete(ad);
        return ResponseEntity.ok().build();
    }
}
