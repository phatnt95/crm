package com.example.crm.clothes.inventory.controller;

import com.example.crm.clothes.inventory.model.Bin;
import com.example.crm.clothes.inventory.model.Storage;
import com.example.crm.clothes.inventory.repository.BinRepository;
import com.example.crm.clothes.inventory.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bin")
public class BinController {
    @Autowired
    private BinRepository binRepository;

    @GetMapping
    public List<Bin> findBins() {
        return binRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveStorage(@RequestBody List<Bin> bins) {
        return ResponseEntity.ok(binRepository.saveAll(bins));
    }

}
//location > cabinet > storage > bin