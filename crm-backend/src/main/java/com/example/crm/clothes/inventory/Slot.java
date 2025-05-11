package com.example.crm.clothes.inventory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "slot")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuId;

    @Column(name = "slot_number", nullable = false)
    private String slotNumber;
}
