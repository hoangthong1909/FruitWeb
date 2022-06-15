package com.example.fruitweb.service.iplm;

import com.example.fruitweb.entities.Discount;
import com.example.fruitweb.repository.ICategoryRepository;
import com.example.fruitweb.repository.IDiscountRepository;
import com.example.fruitweb.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class DiscountService implements IDiscountService {

    @Autowired
    private IDiscountRepository repository;

    @Override
    public List<Discount> findAll() {
        return null;
    }

    @Override
    public Page<Discount> findAllinPage(Pageable pageable) {
        return null;
    }

    @Override
    public Discount insert(Discount discount) {
        return null;
    }

    @Override
    public Discount update(Discount discount) {
        return null;
    }

    @Override
    public Discount detele(Integer id) {
        return null;
    }

    @Override
    public Discount findById(Integer id) {
        return null;
    }
}
