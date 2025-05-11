package com.example.crm.clothes.inventory.service;


import com.example.crm.clothes.inventory.InventoryRequest;
import com.example.crm.clothes.inventory.model.Storage;

import java.util.List;

public interface InventoryService{
    Boolean saveInventory(InventoryRequest request);
}
