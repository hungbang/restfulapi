package com.service;

import com.entity.ProductsEntity;
import com.exception.ProductsNotFoundException;

import java.util.List;

public interface ProductsService {

    List<ProductsEntity> findAll();
    ProductsEntity getProductById(int id) throws ProductsNotFoundException;
    public void updateProduct(ProductsEntity productsEntity);
}
