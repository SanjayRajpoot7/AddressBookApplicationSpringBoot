package com.example.AddressBookApplication.repository;

import com.example.AddressBookApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
