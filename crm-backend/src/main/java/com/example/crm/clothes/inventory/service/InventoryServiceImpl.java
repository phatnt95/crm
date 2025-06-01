package com.example.crm.clothes.inventory.service;

import com.example.crm.clothes.inventory.Inventory;
import com.example.crm.clothes.inventory.InventoryRepository;
import com.example.crm.clothes.inventory.InventoryRequest;
import com.example.crm.clothes.inventory.model.Bin;
import com.example.crm.clothes.inventory.model.InventoryDTO;
import com.example.crm.clothes.inventory.model.Storage;
import com.example.crm.clothes.inventory.repository.StorageRepository;
import com.example.crm.clothes.product.Product;
import com.example.crm.clothes.product.model.ProductDTO;
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
        try{
            List<Inventory> inventoryList = new ArrayList<Inventory>();
            for (Long productId : request.productIDs) {
                Inventory newInventory = Inventory.builder()
                        .product(Product.builder().productId(productId).build())
                        .storage(Storage.builder().uuId(request.storageId).build())
                        .bin(Bin.builder().uuId(request.binId).build())
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

    @Override
    public List<InventoryDTO> findInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream().map(this::mapToInventoryDTO).toList();
    }

    private InventoryDTO mapToInventoryDTO(Inventory inventory) {
        return InventoryDTO.builder()
                .product(ProductDTO.builder()
                        .productName(inventory.getProduct().getProductName())
                        .build())
                .storageName(inventory.getStorage().getStorageName())
                .binNumber(inventory.getBin().getBinNumber())
                .build();
    }


}
