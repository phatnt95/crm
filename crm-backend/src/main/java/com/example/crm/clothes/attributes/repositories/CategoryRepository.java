package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
