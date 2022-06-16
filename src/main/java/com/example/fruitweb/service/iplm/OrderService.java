package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Order;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IOrderRepository;
import com.example.fruitweb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Order> findAllinPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Order insert(Order order) {
        return repository.save(order);
    }

    @Override
    public Order update(Order order) {
        Integer id = order.getId();
        if (id != null) {
            Optional<Order> p = repository.findById(id);
            if (p.isPresent()) {
                return repository.save(order);
            }
        }
        return null;
    }

    @Override
        public Order delete(Integer id) {
            if (id != null) {
                Optional<Order> p = repository.findById(id);
                if (p.isPresent()) {
                    repository.deleteById(id);
                    return p.get();
                }
            }
            return null;
        }

    @Override
    public Order findById(Integer id) {
        return repository.findById(id).get();
    }
}
