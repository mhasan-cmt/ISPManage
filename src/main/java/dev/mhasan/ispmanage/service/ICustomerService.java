package dev.mhasan.ispmanage.service;

import dev.mhasan.ispmanage.dto.CustomerDTO;
import dev.mhasan.ispmanage.entity.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerByEmail(String email);
    Customer addCustomer(CustomerDTO customer);
    List<Customer> getCustomerList();
    Customer getCustomerById(Long id);
}
