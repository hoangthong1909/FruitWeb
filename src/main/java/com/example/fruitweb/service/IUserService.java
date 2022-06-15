package com.example.fruitweb.service;

import com.example.fruitweb.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    public List<User> findAll();
    Page<User> findAllinPage(Pageable pageable);
    User insert(User user);
    User update(User user);
    User detele(Integer id);
    User findById(Integer id);
}
