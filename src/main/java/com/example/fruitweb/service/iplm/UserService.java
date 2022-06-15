package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.User;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IUserRepository;
import com.example.fruitweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Page<User> findAllinPage(Pageable pageable) {
        return null;
    }

    @Override
    public User insert(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User detele(Integer id) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}
