package com.example.fruitweb.service;

import com.example.fruitweb.entities.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDiscountService {
    public List<Discount> findAll();
    Page<Discount> findAllinPage(Pageable pageable);
    Discount insert(Discount discount);
    Discount update(Discount discount);
    Discount delete(Integer id);
    Discount findById(Integer id);
}
