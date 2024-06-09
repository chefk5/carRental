package com.example.carRental.mapper;

import com.example.carRental.dto.CustomerDto;
import com.example.carRental.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getDateOfBirth(),
                customer.getLicenseNbr());
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getEmail(),
                customerDto.getPassword(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getDateOfBirth(),
                customerDto.getLicenseNbr()
        );
    }
}