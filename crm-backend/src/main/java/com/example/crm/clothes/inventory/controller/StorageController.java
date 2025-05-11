package com.example.crm.clothes.inventory.controller;

import com.example.crm.clothes.inventory.model.Cabinet;
import com.example.crm.clothes.inventory.model.Storage;
import com.example.crm.clothes.inventory.repository.CabinetRepository;
import com.example.crm.clothes.inventory.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/storage")
public class StorageController {
    @Autowired
    private StorageRepository storageRepository;

    @GetMapping
    public List<Storage> findStorages() {
        return storageRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveStorage(@RequestBody List<Storage> storages) {
        return ResponseEntity.ok(storageRepository.saveAll(storages));
    }

}
//location > cabinet > storage > bin