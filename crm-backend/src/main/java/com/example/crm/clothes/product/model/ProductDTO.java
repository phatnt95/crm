package com.example.crm.clothes.product.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Getter
@Setter
public class ProductDTO {
    private Long productId;
    private String productName;
    private String description;
    private Double price;

    // Simplified attributes (you can expand these as needed)
    private String category;
    private String type;
    private String color;
    private String size;
    private String style;
    private String neckline;
    private String sleeveLength;
    private String tag;
    private String shoulder;
    private String brand;
    private String occasion;
    private String season;

    private String imageUrl;

    private List<String> imageUrls;
}
