package com.example.fruitweb.service;

import com.example.fruitweb.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();
    Page<Category> findAllinPage(Pageable pageable);
    Category insert(Category category);
    Category update(Category category);
    Category detele(Integer id);
    Category findById(Integer id);
}
