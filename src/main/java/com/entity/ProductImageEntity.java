package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImageEntity {
    private Integer id;
    private String path;
    private Integer product_id;

    public ProductImageEntity(String path) {
        this.id = id;
        this.path = path;
        this.product_id = product_id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "path",nullable = false,unique = true)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name="product_id",nullable = false,unique = true)
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
