package com.example.crm.clothes.attributes.models;

import com.example.crm.clothes.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_image")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;
    @Column(name = "content_type")
    private String contentType;

    @Lob
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
