package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Discount;
import com.example.fruitweb.entities.Order;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IDiscountRepository;
import com.example.fruitweb.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DiscountService implements IDiscountService {

    @Autowired
    private IDiscountRepository repository;

    @Override
    public List<Discount> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Discount> findAllinPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Discount insert(Discount discount) {
        return repository.save(discount);
    }

    @Override
    public Discount update(Discount discount) {
        Integer id = discount.getId();
        if (id != null) {
            Optional<Discount> p = repository.findById(id);
            if (p.isPresent()) {
                return repository.save(discount);
            }
        }
        return null;
    }

    @Override
    public Discount delete(Integer id) {
        if (id != null) {
            Optional<Discount> p = repository.findById(id);
            if (p.isPresent()) {
                repository.deleteById(id);
                return p.get();
            }
        }
        return null;
    }

    @Override
    public Discount findById(Integer id) {
        return repository.findById(id).get();
    }
}
