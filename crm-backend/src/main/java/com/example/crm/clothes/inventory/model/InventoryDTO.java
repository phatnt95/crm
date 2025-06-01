package com.example.crm.clothes.inventory.model;

import com.example.crm.clothes.product.model.ProductDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InventoryDTO {
    public ProductDTO product;
    public String storageName;
    public String binNumber;
}
