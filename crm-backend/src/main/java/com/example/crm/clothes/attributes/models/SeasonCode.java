package com.example.crm.clothes.attributes.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "season_code")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeasonCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "season_code", nullable = false)
    private String seasonCode;

}
