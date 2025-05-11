package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Category;
import com.example.crm.clothes.attributes.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
