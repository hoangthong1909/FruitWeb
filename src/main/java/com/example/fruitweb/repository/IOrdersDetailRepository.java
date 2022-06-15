package com.example.fruitweb.repository;

import com.example.fruitweb.entities.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersDetailRepository extends JpaRepository<OrdersDetail, Integer> {
}