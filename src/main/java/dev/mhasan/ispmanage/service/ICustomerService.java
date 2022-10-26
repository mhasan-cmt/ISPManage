package dev.mhasan.ispmanage.service;

import dev.mhasan.ispmanage.entity.Customer;

public interface ICustomerService {
    Customer getCustomerByEmail(String email);
}
