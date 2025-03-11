package com.example.crm.chat.facebook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaUserRepository extends JpaRepository<MetaUser, Long> {
    MetaUser findByuuId(String uuId);
}
