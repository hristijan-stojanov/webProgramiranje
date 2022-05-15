package com.webshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    Long Id;
    @ManyToOne
    User user;
    @ManyToMany
    List<Product> products;

    public ShoppingCart(User user) {
        this.user = user;
        products= new ArrayList<>();
    }

    public ShoppingCart() {
        products= new ArrayList<>();
    }

    public ShoppingCart(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return Id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }
    public void AddProduct(Product product){
        this.products.add(product);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
