package com.example.crm.clothes.inventory.repository;

import com.example.crm.clothes.inventory.Slot;
import com.example.crm.clothes.inventory.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepository extends JpaRepository<Bin, Long> {
}
