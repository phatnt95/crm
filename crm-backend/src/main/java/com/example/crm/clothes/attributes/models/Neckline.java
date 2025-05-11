package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "neckline")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Neckline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code; // e.g., "S," "M," "L", 42, 43

    @Column(name = "neckline_style", nullable = false)
    private String necklineStyle;
}
