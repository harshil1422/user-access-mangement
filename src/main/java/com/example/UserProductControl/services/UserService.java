package com.example.UserProductControl.services;

import com.example.UserProductControl.dtos.UserDTO;

public interface UserService {
    UserDTO createUserByAdmin(UserDTO userDTO);
}
