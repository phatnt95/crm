package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Category;
import com.example.crm.clothes.attributes.models.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Style, Long> {
}
