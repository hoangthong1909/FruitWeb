package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Discount;
import com.example.fruitweb.entities.User;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IUserRepository;
import com.example.fruitweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<User> findAllinPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User insert(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        Integer id = user.getId();
        if (id != null) {
            Optional<User> p = repository.findById(id);
            if (p.isPresent()) {
                return repository.save(user);
            }
        }
        return null;
    }

    @Override
    public User delete(Integer id) {
        if (id != null) {
            Optional<User> p = repository.findById(id);
            if (p.isPresent()) {
                repository.deleteById(id);
                return p.get();
            }
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
