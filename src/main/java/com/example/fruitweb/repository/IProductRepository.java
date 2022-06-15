package com.example.fruitweb.repository;

import com.example.fruitweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}