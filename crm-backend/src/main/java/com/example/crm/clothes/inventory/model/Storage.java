package com.example.crm.clothes.inventory.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "storage")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="storage_code")
    private Long uuId;

    @Column(name = "storage_name")
    private String storageName;

    @ManyToOne
    @JoinColumn(name="cabinet_code")
    private Cabinet cabinet;

}
