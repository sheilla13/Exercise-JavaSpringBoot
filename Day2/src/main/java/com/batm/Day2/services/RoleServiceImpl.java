package com.batm.Day2.services;

import com.batm.Day2.DTO.User.RegisterDTO;
import com.batm.Day2.DTO.User.UserGridDTO;
import com.batm.Day2.entities.Role;
import com.batm.Day2.entities.User;
import com.batm.Day2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class RoleServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean register(RegisterDTO dto) {
        if (dto.getUsername().isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty!");
        }
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        userRepository.save(new User(dto.getUsername(), encodedPassword, new Role(1)));
        return userRepository.findById(dto.getUsername()).isPresent();
    }

    @Override
    public List<UserGridDTO> findAllUsers() {
        return userRepository.getUsernameRoleName();
    }
}