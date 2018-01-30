package com.controller;

import com.entity.ProductsEntity;
import com.exception.ProductsNotFoundException;
import com.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public ModelAndView getAllProduct(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("products",productsService.findAll());
        modelAndView.setViewName("productsList");
        return modelAndView;
    }

}
