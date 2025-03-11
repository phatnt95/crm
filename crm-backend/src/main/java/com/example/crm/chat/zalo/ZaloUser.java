package com.example.crm.chat.zalo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zalo_users") // Optional: Specify table name
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZaloUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String uuId; // zalo_user_id
}
