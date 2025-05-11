package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "code", nullable = false)
    private String categoryCode;
    @Column(name = "name", nullable = false)
    private String categoryName;

    private String description;
}
