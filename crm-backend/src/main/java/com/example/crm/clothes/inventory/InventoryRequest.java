package com.example.crm.clothes.inventory;

import com.example.crm.clothes.inventory.model.Bin;
import com.example.crm.clothes.inventory.model.Storage;
import com.example.crm.clothes.product.Product;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequest {
    public List<Product> productList;
    public Storage storage;
    public Bin bin;
}
