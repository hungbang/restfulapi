package com.controller;

import com.entity.ProductsEntity;
import com.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;


    @RequestMapping(value = "/rest/protected/v1.0/api/products/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductsEntity> updateProduct(@PathVariable("id") int id) {
        System.out.print("Updating Product :" + id);
        ProductsEntity currentProduct = productsService.getProductById(id);
        if (currentProduct == null) {
            System.out.println("User with id :" + id + "not found");
            return new ResponseEntity<ProductsEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductsEntity>(currentProduct,HttpStatus.OK);
    }
}