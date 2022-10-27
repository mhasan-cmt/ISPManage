package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.dto.CustomerDTO;
import dev.mhasan.ispmanage.entity.Customer;
import dev.mhasan.ispmanage.repository.CustomerRepository;
import dev.mhasan.ispmanage.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer addCustomer(CustomerDTO customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return null;
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
