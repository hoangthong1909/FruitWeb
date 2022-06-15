package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Order;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IOrderRepository;
import com.example.fruitweb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository repository;

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Page<Order> findAllinPage(Pageable pageable) {
        return null;
    }

    @Override
    public Order insert(Order order) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order detele(Integer id) {
        return null;
    }

    @Override
    public Order findById(Integer id) {
        return null;
    }
}
