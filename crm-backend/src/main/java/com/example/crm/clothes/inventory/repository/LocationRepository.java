package com.example.crm.clothes.inventory.repository;

import com.example.crm.clothes.inventory.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
