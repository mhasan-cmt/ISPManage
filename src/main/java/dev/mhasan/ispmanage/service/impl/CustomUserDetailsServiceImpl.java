package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.entity.Customer;
import dev.mhasan.ispmanage.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        if(user==null) {
            log.error("User not found with username: {}", username);
            throw new UsernameNotFoundException(username + "not found");
        }
        return user;
    }
}
