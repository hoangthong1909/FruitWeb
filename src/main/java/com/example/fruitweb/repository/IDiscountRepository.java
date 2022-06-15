package com.example.fruitweb.repository;

import com.example.fruitweb.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
}