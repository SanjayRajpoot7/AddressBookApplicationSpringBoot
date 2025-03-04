package com.example.AddressBookApplication.service;

import com.example.AddressBookApplication.dto.UserDTO;
import com.example.AddressBookApplication.model.User;
import com.example.AddressBookApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users as a list of DTOs
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            return dto;
        }).collect(Collectors.toList());
    }

    // Get a user by ID as a DTO
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            return dto;
        }
        return null;
    }

    // Save a new user
    public UserDTO saveUser(User user) {
        User savedUser = userRepository.save(user);
        UserDTO dto = new UserDTO();
        dto.setId(savedUser.getId());
        dto.setFirstName(savedUser.getFirstName());
        dto.setLastName(savedUser.getLastName());
        return dto;
    }
}