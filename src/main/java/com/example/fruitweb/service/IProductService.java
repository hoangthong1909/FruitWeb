package com.example.fruitweb.service;

import com.example.fruitweb.entities.Product;
import com.example.fruitweb.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    Page<Product> findAllinPage(Pageable pageable);
    Product insert(Product product);
    Product update(Product product);
    Product delete(Integer id);
    Product findById(Integer id);
}
