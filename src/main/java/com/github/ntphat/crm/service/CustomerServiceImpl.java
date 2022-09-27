package com.github.ntphat.crm.service;

import com.github.ntphat.crm.data.Customer;
import com.github.ntphat.crm.dto.CustomerDTO;
import com.github.ntphat.crm.repository.CustomerRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl   {
    @Autowired
    CustomerRepository customerRepository;

//    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(@NotNull CustomerDTO customerDTO) {
        Customer newCustomer = new Customer(customerDTO);
            return customerRepository.save(newCustomer);
    }
}
