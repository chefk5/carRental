package com.example.carRental.service.impl;

import com.example.carRental.dto.CustomerDto;
import com.example.carRental.entity.Customer;
import com.example.carRental.exception.ResourceAlreadyExistsException;
import com.example.carRental.exception.ResourceNotFoundException;
import com.example.carRental.mapper.CustomerMapper;
import com.example.carRental.repository.CustomerRepository;
import com.example.carRental.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto){
        Optional<Customer> duplicateCustomer = customerRepository.findByEmail(customerDto.getEmail());
        if(duplicateCustomer.isPresent()){
            throw new ResourceAlreadyExistsException("A customer with same email exists");
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::mapToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto updatedCustomer) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customer.setEmail(updatedCustomer.getEmail());
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setPassword(updatedCustomer.getPassword());
        customer.setDateOfBirth(updatedCustomer.getDateOfBirth());
        customer.setLicenseNbr(updatedCustomer.getLicenseNbr());

        Customer updatedCustomerObj = customerRepository.save(customer);

        return CustomerMapper.mapToCustomerDto(updatedCustomerObj);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> customer =  customerRepository.findById(customerId);
        customerRepository.deleteById(customerId);
    }


}
