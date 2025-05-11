package com.example.crm.clothes.common;

import com.example.crm.clothes.inventory.InventoryRepository;
import com.example.crm.clothes.inventory.repository.LocationRepository;
import com.example.crm.clothes.inventory.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class GenericServiceImpl implements GenericService{

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private SlotRepository slotRepository;

    @Override
    public <T, ID> Optional<T> createModel(T model, JpaRepository<T, ID> repository) {
        try {
            // Validate the model
            if (model == null) {
                return Optional.empty();
            }

            T savedModel = repository.save(model);
            return Optional.of(savedModel);

        } catch (Exception e) {
            System.err.println("Error creating model: " + e.getMessage());
            return Optional.empty();
        }
    }
}
