package com.example.fruitweb.service;

import com.example.fruitweb.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    public List<Order> findAll();
    Page<Order> findAllinPage(Pageable pageable);
    Order insert(Order order);
    Order update(Order order);
    Order detele(Integer id);
    Order findById(Integer id);
}
