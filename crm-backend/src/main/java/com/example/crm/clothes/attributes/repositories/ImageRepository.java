package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Category;
import com.example.crm.clothes.attributes.models.Image;
import com.example.crm.clothes.attributes.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ProductImage, Long> {
//    List<ProductImage> findAllByProductId(Long productId);
}
