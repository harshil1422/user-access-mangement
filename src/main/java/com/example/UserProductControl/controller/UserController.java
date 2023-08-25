package com.example.UserProductControl.controller;

import com.example.UserProductControl.dtos.UserDTO;
import com.example.UserProductControl.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/admin/create")
    public ResponseEntity<UserDTO> createUserByAdmin(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUserByAdmin(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    // Add more methods for user management (update, delete, etc.)
}
