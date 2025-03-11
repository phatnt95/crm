package com.example.crm.chat.facebook;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meta_users") // Optional: Specify table name
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String uuId; // zalo_user_id
}
