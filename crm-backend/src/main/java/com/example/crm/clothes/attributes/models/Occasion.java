package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "occasion")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Occasion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "occasion_id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;


    @Column(nullable = false)
    private String occasion;
}
