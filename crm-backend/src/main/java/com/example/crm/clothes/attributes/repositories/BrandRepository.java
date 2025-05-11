package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Brand;
import com.example.crm.clothes.attributes.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
