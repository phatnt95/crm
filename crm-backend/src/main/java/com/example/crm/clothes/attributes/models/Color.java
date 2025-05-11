package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "colors")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;

    @Column(name = "color_code", nullable = false)
    private String colorCode;

    private String description;
}
