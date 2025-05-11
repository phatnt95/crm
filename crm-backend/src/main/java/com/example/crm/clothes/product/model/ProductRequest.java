package com.example.crm.clothes.product.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    public String productName;
    public String description;
    public Long categoryId;
    public Long colorId;
    public Long sizeId;
    public Long styleId;
    public Long tagId;
    public Long sleeveLengthId;
}
