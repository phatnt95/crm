package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Category;
import com.example.crm.clothes.attributes.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
