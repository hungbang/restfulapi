package com.controller;

import com.entity.ProductsEntity;
import com.exception.ProductsNotFoundException;
import com.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/rest/protected/v1.0/api/products",method = RequestMethod.GET)
    public ResponseEntity<List<ProductsEntity>> listAllProducts(){
        List<ProductsEntity> productsEntities=productsService.findAll();
        if(productsEntities.isEmpty()){
            return new ResponseEntity<List<ProductsEntity>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductsEntity>>(productsEntities,HttpStatus.OK);
    }

}
