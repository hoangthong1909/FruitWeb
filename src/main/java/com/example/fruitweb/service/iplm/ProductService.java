package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Product;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IProductRepository;
import com.example.fruitweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Page<Product> findAllinPage(Pageable pageable) {
        return null;
    }

    @Override
    public Product insert(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product detele(Integer id) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }
}
