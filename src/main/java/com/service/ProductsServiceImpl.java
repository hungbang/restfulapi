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

    @Override
    public ProductsEntity getProductById(int id) throws ProductsNotFoundException {
        if(productRepository.findOne(id)==null)
            throw new ProductsNotFoundException("Product does not exists.");
        return productRepository.findOne(id);
    }

    @Override
    public void updateProduct(ProductsEntity productsEntity) {
        productRepository.save(productsEntity);
    }

    @Override
    public void deleteProduct(ProductsEntity productsEntity) {
        productRepository.delete(productsEntity);
    }
}
