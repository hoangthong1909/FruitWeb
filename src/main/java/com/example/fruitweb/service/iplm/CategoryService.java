package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Category;
import com.example.fruitweb.entities.Order;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Category> findAllinPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Category insert(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        Integer id = category.getId();
        if (id != null) {
            Optional<Category> p = repository.findById(id);
            if (p.isPresent()) {
                return repository.save(category);
            }
        }
        return null;
    }

    @Override
    public Category delete(Integer id) {
        if (id != null) {
            Optional<Category> p = repository.findById(id);
            if (p.isPresent()) {
                repository.deleteById(id);
                return p.get();
            }
        }
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id).get();
    }
}
