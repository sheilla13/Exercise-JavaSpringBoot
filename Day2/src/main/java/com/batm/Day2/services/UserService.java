package com.batm.Day2.services;

import com.batm.Day2.DTO.User.RegisterDTO;
import com.batm.Day2.DTO.User.UserGridDTO;

import java.util.List;

public interface UserService {
    boolean register(RegisterDTO dto);
    List<UserGridDTO> findAllUsers();
}
