package com.example.fruitweb.repository;

import com.example.fruitweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}