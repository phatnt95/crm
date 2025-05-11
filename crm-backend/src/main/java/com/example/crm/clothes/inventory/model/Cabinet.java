package com.example.crm.clothes.inventory.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "cabinet")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cabinet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cabinet_code")
    private Long uuId;

    @Column(name="cabinet_name")
    private String cabinetName;

    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name="location_code")
    private Location location;
}
