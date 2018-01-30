package com.controller;

import com.service.ProductImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ProductImageController {
    public static final Logger LOGGER= LoggerFactory.getLogger(ProductImageController.class);
    public static final String UPLOADED_FOLDER="";

    @Autowired
    private ProductImageService productImageService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<?> UploadImage(@RequestParam("file")MultipartFile file) throws IOException{
        LOGGER.info("func UploadImage() called");
        if(file.isEmpty()){
            throw new RuntimeException();
        }

        byte[] bytes=file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER +file.getOriginalFilename());
        String pathName=file.getOriginalFilename();
        productImageService.createImage(pathName);
        Files.write(path,bytes);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
