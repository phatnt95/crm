package com.example.crm.clothes.inventory.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "location")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuId;

    @Column(name = "location_code", nullable = false)
    private String locationCode;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    private String address;
}
