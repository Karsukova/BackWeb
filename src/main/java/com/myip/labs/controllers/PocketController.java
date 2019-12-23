package com.myip.labs.controllers;

import com.myip.labs.dto.PocketDTO;
import com.myip.labs.entity.User;
import com.myip.labs.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PocketController {
    @Autowired
    private PocketService pocketService;

    @GetMapping
    public List<PocketDTO> getAllPockets(@AuthenticationPrincipal User user) {
        return pocketService.findAllByUser(user);
    }

    @PostMapping("/pocket")
    public ResponseEntity<String> createPocket(@Valid  @RequestBody PocketDTO pocket,
                                               @AuthenticationPrincipal User user)
    {
        pocketService.save(pocket, user);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/pocket/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id, @AuthenticationPrincipal User user) {
        pocketService.delete(id, user);
        return ResponseEntity.ok("Deleted");
    }

}