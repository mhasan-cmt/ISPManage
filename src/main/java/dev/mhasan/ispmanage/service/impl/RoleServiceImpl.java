package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.entity.Role;
import dev.mhasan.ispmanage.repository.RoleRepository;
import dev.mhasan.ispmanage.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
