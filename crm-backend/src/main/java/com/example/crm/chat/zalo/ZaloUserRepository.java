package com.example.crm.chat.zalo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZaloUserRepository extends JpaRepository<ZaloUser, Long> {
    ZaloUser findByuuId(String uuId);
}
