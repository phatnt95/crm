package com.github.ntphat.crm.controller;

import com.github.ntphat.crm.dto.CustomerDTO;
import com.github.ntphat.crm.service.CustomerService;
import com.github.ntphat.crm.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
@Slf4j
@RestController
public class CustomerCtrl {
    @Autowired
    public CustomerServiceImpl customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity find(@RequestParam Integer skip, @RequestParam Integer take) {
        return ResponseEntity.ok(customerService.findAll());
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody CustomerDTO customerDTO) {

        return ResponseEntity.ok(customerService.save(customerDTO));
    }
}
