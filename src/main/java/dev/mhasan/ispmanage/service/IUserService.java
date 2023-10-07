package dev.mhasan.ispmanage.service;

import dev.mhasan.ispmanage.entity.User;

public interface IUserService {
    User findByEmail(String email);
    void save(User user);
    void update(User user);
    void delete(Long id);
    User findById(Long id);
    Boolean existsByEmail(String email);
}
