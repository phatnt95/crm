package com.github.ntphat.crm.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<String> find(Integer skip, Integer take);
}
