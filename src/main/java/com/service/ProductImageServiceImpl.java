package com.service;

import com.entity.ProductImageEntity;
import com.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public ProductImageEntity createImage(String path) {
        ProductImageEntity productImageEntity=new ProductImageEntity(path);
        return productImageRepository.save(productImageEntity);
    }
}
