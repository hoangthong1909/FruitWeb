package com.example.fruitweb.service;

import com.example.fruitweb.entities.OrdersDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderDetailService {
    public List<OrdersDetail> findAll();
    Page<OrdersDetail> findAllinPage(Pageable pageable);
    OrdersDetail insert(OrdersDetail ordersDetail);
    OrdersDetail update(OrdersDetail ordersDetail);
    OrdersDetail detele(Integer id);
    OrdersDetail findById(Integer id);
}
