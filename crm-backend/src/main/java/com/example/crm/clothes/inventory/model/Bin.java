package com.example.crm.clothes.inventory.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "bin")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bin  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bin_code")
    private Long uuId;

    @Column(name = "bin_number")
    private String binNumber;

    @JoinColumn(name="storage_code")
    private Storage storage;
}
