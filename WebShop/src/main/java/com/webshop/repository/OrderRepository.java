package com.webshop.repository;

import com.webshop.model.Order;
import com.webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
