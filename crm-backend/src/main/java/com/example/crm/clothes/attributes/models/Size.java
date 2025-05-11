package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sizes")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code; // e.g., "S," "M," "L", 42, 43

    @Column(name = "size_label", nullable = false)
    private String sizeLabel;

    @Column(nullable = false)
    private String Region;

    private String description;
}
