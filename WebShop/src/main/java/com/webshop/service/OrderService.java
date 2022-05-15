package com.webshop.service;

import com.webshop.model.Order;
import com.webshop.model.ShoppingCart;
import com.webshop.model.User;

public interface OrderService {

    Order AddOrder(Long id,String username);
}
