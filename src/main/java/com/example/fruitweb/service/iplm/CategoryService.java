package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Category;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;
    
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Page<Category> findAllinPage(Pageable pageable) {
        return null;
    }

    @Override
    public Category insert(Category category) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category detele(Integer id) {
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }
}
