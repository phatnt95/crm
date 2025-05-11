package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sleeve_length")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SleeveLength {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    private String description;
}
