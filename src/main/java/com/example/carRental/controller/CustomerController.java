package com.example.carRental.controller;


import com.example.carRental.dto.CustomerDto;
import com.example.carRental.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long customerId){
        CustomerDto customerWithId = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerWithId);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long customerId, @RequestBody CustomerDto updatedCustomer){
        CustomerDto customerDto = customerService.updateCustomer(customerId, updatedCustomer);
        return ResponseEntity.ok(customerDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Employee deleted");
    }
}
