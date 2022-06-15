package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.OrdersDetail;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IOrderRepository;
import com.example.fruitweb.repository.IOrdersDetailRepository;
import com.example.fruitweb.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OrderDetailsService implements IOrderDetailService {

    @Autowired
    private IOrdersDetailRepository repository;

    @Override
    public List<OrdersDetail> findAll() {
        return null;
    }

    @Override
    public Page<OrdersDetail> findAllinPage(Pageable pageable) {
        return null;
    }

    @Override
    public OrdersDetail insert(OrdersDetail ordersDetail) {
        return null;
    }

    @Override
    public OrdersDetail update(OrdersDetail ordersDetail) {
        return null;
    }

    @Override
    public OrdersDetail detele(Integer id) {
        return null;
    }

    @Override
    public OrdersDetail findById(Integer id) {
        return null;
    }
}
