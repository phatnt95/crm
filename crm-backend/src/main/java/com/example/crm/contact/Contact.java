package com.example.crm.contact;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contacts") // Optional: Specify table name
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String email;
    private String phone;
    private String company;

    public Contact (String name, String email, String phone, String company) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }
}