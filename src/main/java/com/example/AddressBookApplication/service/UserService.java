package com.example.AddressBookApplication.service;

import com.example.AddressBookApplication.dto.UserDTO;
import com.example.AddressBookApplication.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    // Create a new user
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setId(nextId++);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        users.add(user);
        return userDTO;
    }

    // Get all users
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setEmail(user.getEmail());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    // Get user by ID
    public UserDTO getUserById(Long id) {
        Optional<User> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.get().getId());
            userDTO.setFirstName(user.get().getFirstName());
            userDTO.setLastName(user.get().getLastName());
            userDTO.setEmail(user.get().getEmail());
            return userDTO;
        } else {
            return null;
        }
    }

    // Update user by ID
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> userOpt = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            return userDTO;
        } else {
            return null;
        }
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}