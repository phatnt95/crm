package com.example.crm.clothes.inventory.service;

import com.example.crm.clothes.inventory.Inventory;
import com.example.crm.clothes.inventory.InventoryRepository;
import com.example.crm.clothes.inventory.InventoryRequest;
import com.example.crm.clothes.inventory.model.Bin;
import com.example.crm.clothes.inventory.model.Storage;
import com.example.crm.clothes.inventory.repository.StorageRepository;
import com.example.crm.clothes.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    StorageRepository storageRepository;
    /**
     * @param request
     * @return
     */
    @Override
    public Boolean saveInventory(InventoryRequest request) {
        Boolean saveFlag = true;
        Storage storage = request.storage;
        Bin bin = request.bin;
        try{
            List<Inventory> inventoryList = new ArrayList<Inventory>();
            for (Product product : request.productList) {
                Inventory newInventory = Inventory.builder()
                        .product(product)
                        .storage(storage)
                        .bin(bin)
                        .build();
                inventoryList.add(newInventory);
            }
            if(!inventoryList.isEmpty()) {
                inventoryRepository.saveAll(inventoryList);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return saveFlag;
    }
}
