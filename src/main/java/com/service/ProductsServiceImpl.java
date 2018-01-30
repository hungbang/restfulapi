package com.service;

import com.entity.ProductsEntity;
import com.exception.ProductsNotFoundException;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductsEntity> findAll() {
        return productRepository.findAll();
    }


}
