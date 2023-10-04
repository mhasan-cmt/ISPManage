package dev.mhasan.ispmanage.service;

import dev.mhasan.ispmanage.entity.Role;

public interface IRoleService {
    Role findByName(String name);
    void save(Role role);
}
