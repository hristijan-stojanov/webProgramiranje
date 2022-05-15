package com.webshop.service;

import com.webshop.model.Product;
import com.webshop.model.ShoppingCart;
import com.webshop.model.User;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart findById(Long id);
    List<Product> listAllProducts(Long id);
    ShoppingCart addProduct(String username, Long productId);
    ShoppingCart getShoppingCart(User  user);
    ShoppingCart deletProduct(ShoppingCart shoppingCart, Long id);
    public ShoppingCart delet(ShoppingCart shoppingCart);

}
