//package com.example.AddressBookApplication.service;
//
//import com.example.AddressBookApplication.dto.UserDTO;
//import com.example.AddressBookApplication.model.User;
//import com.example.AddressBookApplication.repository.UserRepository;
//import com.example.AddressBookApplication.service.UserService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
////
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Override
//    public UserDTO createUser(UserDTO userDTO) {
//        // Convert UserDTO to User entity
//        User user = modelMapper.map(userDTO, User.class);
//        user = userRepository.save(user);
//
//        // Convert saved User entity back to UserDTO
//        return modelMapper.map(user, UserDTO.class);
//    }
//
//    @Override
//    public List<UserDTO> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(user -> modelMapper.map(user, UserDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDTO getUserById(Long id) {
//        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//        return modelMapper.map(user, UserDTO.class);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//}