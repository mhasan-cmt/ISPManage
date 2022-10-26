package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.entity.Customer;
import dev.mhasan.ispmanage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomerByEmail(username);
        if(customer==null) {
            System.err.println("exception thrown");
            throw new UsernameNotFoundException(username + "not found");
        }
        return new CustomUserDetails(customer);
    }
}
