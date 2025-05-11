package com.example.crm.clothes.attributes.repositories;

import com.example.crm.clothes.attributes.models.Brand;
import com.example.crm.clothes.attributes.models.SeasonCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonCodeRepository extends JpaRepository<SeasonCode, Long> {
}
