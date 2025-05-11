package com.example.crm.clothes.attributes.models;

import com.example.crm.clothes.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Long imageId;


    @JoinColumn(name="product_id")
    @ManyToOne    private Product product;

    private String filename;
    private String contentType;

    @Lob
    private byte[] data;
}
