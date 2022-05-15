package com.webshop.repository;

import com.webshop.model.ShoppingCart;
import com.webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findByUser(User user);
}
