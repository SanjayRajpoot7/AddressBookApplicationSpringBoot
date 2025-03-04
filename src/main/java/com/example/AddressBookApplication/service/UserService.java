package com.example.AddressBookApplication.service;

import com.example.AddressBookApplication.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    void deleteUser(Long id);
}