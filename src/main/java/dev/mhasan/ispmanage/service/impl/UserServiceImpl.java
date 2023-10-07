package dev.mhasan.ispmanage.service.impl;

import dev.mhasan.ispmanage.entity.User;
import dev.mhasan.ispmanage.repository.UserRepository;
import dev.mhasan.ispmanage.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        User userFromDB = userRepository.findById(user.getId()).orElse(null);
        if(userFromDB!=null) {
            userFromDB.setFirstName(user.getFirstName());
            userFromDB.setLastName(user.getLastName());
            userFromDB.setEmail(user.getEmail());
            userFromDB.setRoles(user.getRoles());
            userFromDB.setEnabled(user.isEnabled());
            userRepository.save(userFromDB);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
