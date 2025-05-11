package com.example.crm.clothes.inventory;

import com.example.crm.clothes.inventory.model.Bin;
import com.example.crm.clothes.inventory.model.Storage;
import com.example.crm.clothes.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "inventory")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "storage_code")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "bin_code")
    private Bin bin;

}
