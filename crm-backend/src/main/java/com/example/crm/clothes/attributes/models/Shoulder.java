package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shoulder")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shoulder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code; // e.g., "S," "M," "L", 42, 43

    @Column(name = "shoulder_style", nullable = false)
    private String shoulderStyle;
}
