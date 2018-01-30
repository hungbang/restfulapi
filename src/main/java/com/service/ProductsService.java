package com.service;

import com.entity.ProductsEntity;
import com.exception.ProductsNotFoundException;

import java.util.List;

public interface ProductsService {
    List<ProductsEntity> findAll();


}
