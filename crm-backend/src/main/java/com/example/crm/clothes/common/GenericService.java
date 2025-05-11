package com.example.crm.clothes.common;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenericService {
    <T, ID> Optional<T> createModel(T model, JpaRepository<T, ID> repository);
}
