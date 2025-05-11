package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Brand;
import com.example.crm.clothes.attributes.models.Occasion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccasionRepository extends JpaRepository<Occasion, Long> {
}
