package com.example.crm.clothes.inventory;

import com.example.crm.clothes.inventory.model.Storage;
import com.example.crm.clothes.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    // post method
    @PostMapping(path = "/inventory")
    public ResponseEntity<?> createInventory(@RequestBody InventoryRequest inventoryRequest) {
        return ResponseEntity.ok(inventoryService.saveInventory(inventoryRequest));
    }



}

