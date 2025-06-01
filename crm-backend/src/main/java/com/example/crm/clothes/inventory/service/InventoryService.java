package com.example.crm.clothes.inventory.service;


import com.example.crm.clothes.inventory.Inventory;
import com.example.crm.clothes.inventory.InventoryRequest;
import com.example.crm.clothes.inventory.model.InventoryDTO;
import com.example.crm.clothes.inventory.model.Storage;

import java.util.List;

public interface InventoryService{
    Boolean saveInventory(InventoryRequest request);
    List<InventoryDTO> findInventories();
}
