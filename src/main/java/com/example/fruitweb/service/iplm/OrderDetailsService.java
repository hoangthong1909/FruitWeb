package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Order;
import com.example.fruitweb.entities.OrdersDetail;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IOrderRepository;
import com.example.fruitweb.repository.IOrdersDetailRepository;
import com.example.fruitweb.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderDetailsService implements IOrderDetailService {

    @Autowired
    private IOrdersDetailRepository repository;

    @Override
    public List<OrdersDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<OrdersDetail> findAllinPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public OrdersDetail insert(OrdersDetail ordersDetail) {
        return repository.save(ordersDetail);
    }

    @Override
    public OrdersDetail update(OrdersDetail ordersDetail) {
        Integer id = ordersDetail.getId();
        if (id != null) {
            Optional<OrdersDetail> p = repository.findById(id);
            if (p.isPresent()) {
                return repository.save(ordersDetail);
            }
        }
        return null;
    }

    @Override
    public OrdersDetail delete(Integer id) {
        if (id != null) {
            Optional<OrdersDetail> p = repository.findById(id);
            if (p.isPresent()) {
                repository.deleteById(id);
                return p.get();
            }
        }
        return null;
    }

    @Override
    public OrdersDetail findById(Integer id) {
        return repository.findById(id).get();
    }
}
