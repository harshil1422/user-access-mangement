package com.example.UserProductControl.services.serviceImpl;

import com.example.UserProductControl.dtos.UserDTO;
import com.example.UserProductControl.entities.User;
import com.example.UserProductControl.repository.UserRepository;
import com.example.UserProductControl.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private ModelMapper modelMapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUserByAdmin(UserDTO userDTO) {
        User saveUser = userRepository.save(mapToEntity(userDTO));
        return mapToDto(saveUser);
    }


    private User mapToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }

    private  UserDTO mapToDto(User user){
        return modelMapper.map(user,UserDTO.class);
    }
}
