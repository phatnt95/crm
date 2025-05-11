package com.example.crm.clothes.inventory.controller;

import com.example.crm.clothes.inventory.model.Cabinet;
import com.example.crm.clothes.inventory.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cabinet")
public class CabinetController {
    @Autowired
    private CabinetRepository cabinetRepository;

    @GetMapping
    public List<Cabinet> findCabinets() {
        return cabinetRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveCabinet(@RequestBody List<Cabinet> cabinets) {
        return ResponseEntity.ok(cabinetRepository.saveAll(cabinets));
    }

}
//location > cabinet > storage > bin