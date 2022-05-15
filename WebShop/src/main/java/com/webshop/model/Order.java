package com.webshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue
    Long Id;

    @ManyToMany
    List<ShoppingCart> shoppingCart;

    public Order() {
        shoppingCart=new ArrayList<>();
    }

    public Order(List<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Long getId() {
        return Id;
    }

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setShoppingCart(List<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
