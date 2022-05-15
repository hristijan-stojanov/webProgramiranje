package com.webshop.service.impl;

import com.webshop.model.Order;
import com.webshop.model.ShoppingCart;
import com.webshop.model.User;
import com.webshop.model.exceptions.InvalidUserException;
import com.webshop.repository.OrderRepository;
import com.webshop.repository.UserRepository;
import com.webshop.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    public final UserRepository userRepository;
    private final ShoppingCartServiceImpl shoppingCartService;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ShoppingCartServiceImpl shoppingCartService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;

        this.shoppingCartService = shoppingCartService;
    }



    @Override
    public Order AddOrder(Long id, String username) {
        User user= this.userRepository.findByUsername(username).orElseThrow(InvalidUserException::new);
       ShoppingCart shoppingCart= this.shoppingCartService.findById(id);
       Order order= new Order();
       order.getShoppingCart().add(shoppingCart);



        return this.orderRepository.save(order);
    }
}
