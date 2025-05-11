package com.example.crm.clothes.inventory.controller;

import com.example.crm.clothes.inventory.model.Location;
import com.example.crm.clothes.inventory.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Location> findLocations() {
        return locationRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveLocations(@RequestBody List<Location> locations) {
        return ResponseEntity.ok(locationRepository.saveAll(locations));
    }

}
