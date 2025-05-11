package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Brand;
import com.example.crm.clothes.attributes.models.Neckline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NecklineRepository extends JpaRepository<Neckline, Long> {
}
