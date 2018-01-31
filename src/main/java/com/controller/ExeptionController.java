package com.controller;

import com.exception.ProductsNotFoundException;
import com.exception.ResponeErrorMessage;
import com.exception.TokenInvalidExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExeptionController {

    ResponeErrorMessage message;

    public ExeptionController() {
        this.message = message;
    }

    @ExceptionHandler(TokenInvalidExeption.class)
    public ModelAndView hadleTokenInvalidException(TokenInvalidExeption tokenInvalidExeption){
        message.setCode(HttpStatus.BAD_REQUEST);
        message.setMessage(tokenInvalidExeption.getMessage());

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message",message);
        return modelAndView;
    }
    @ExceptionHandler(ProductsNotFoundException.class)
    public ModelAndView hadleProductsNotFoundException(ProductsNotFoundException productsNotFoundExeption){
        message.setCode(HttpStatus.BAD_REQUEST);
        message.setMessage(productsNotFoundExeption.getMessage());

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message1",message);
        return modelAndView;
    }
}
