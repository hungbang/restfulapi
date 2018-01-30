package com.entity;

import javax.persistence.*;

@Entity
@Table(name="products")
public class ProductsEntity {
    private Integer id;
    private String created;
    private String description;
    private String name;
    private String price;
    private String user_id;
    private String group_id;

    public ProductsEntity(Integer id, String created, String description, String name, String price, String user_id, String group_id) {
        this.id = id;
        this.created = created;
        this.description = description;
        this.name = name;
        this.price = price;
        this.user_id = user_id;
        this.group_id = group_id;
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
    @Column(name="created",nullable = false,unique = true)
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
    @Column(name="description",nullable = false,unique = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name="name",nullable = false,unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="price",nullable = false,unique = true)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Column(name = "user_id",nullable = false,unique = true)
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    @Column(name = "group_id",nullable = false,unique = true)
    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "ProductsEntity{" +
                "id=" + id +
                ", created='" + created + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", user_id='" + user_id + '\'' +
                ", group_id='" + group_id + '\'' +
                '}';
    }
}
