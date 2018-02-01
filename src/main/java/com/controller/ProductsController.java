package com.controller;

import com.entity.ProductsEntity;
import com.exception.ProductsNotFoundException;
import com.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;


    @RequestMapping(value = "/rest/protected/v1.0/api/products/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductsEntity> updateProduct(@PathVariable("id") int id) throws ProductsNotFoundException {
        System.out.print("Updating Product :" + id);
        ProductsEntity currentProduct = productsService.getProductById(id);
        if (currentProduct == null) {
            System.out.println("User with id :" + id + "not found");
            return new ResponseEntity<ProductsEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductsEntity>(currentProduct,HttpStatus.OK);
    }

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public ResponseEntity<List<ProductsEntity>> listAllProducts(){
        List<ProductsEntity> productsEntities=productsService.findAll();
        if(productsEntities.isEmpty()){
            return new ResponseEntity<List<ProductsEntity>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductsEntity>>(productsEntities,HttpStatus.OK);
    }
    @RequestMapping(value ="/products/edit/{id}" ,method = RequestMethod.PUT)
    public ResponseEntity<ProductsEntity> updateProduct(@PathVariable("id") int id,
                                                        @RequestBody ProductsEntity productsEntity) throws ProductsNotFoundException {
        System.out.print("Updating Product :" +id);
        ProductsEntity currentProduct=productsService.getProductById(id);
        if(currentProduct==null){
            System.out.println("User with id :" + id + "not found");
            return new ResponseEntity<ProductsEntity>(HttpStatus.NOT_FOUND);
        }
        currentProduct.setName(productsEntity.getName());
        currentProduct.setDescription(productsEntity.getDescription());
        currentProduct.setCreated(productsEntity.getCreated());
        currentProduct.setPrice(productsEntity.getPrice());

        productsService.updateProduct(currentProduct);
        return new ResponseEntity<ProductsEntity>(currentProduct,HttpStatus.OK);
    }
}
