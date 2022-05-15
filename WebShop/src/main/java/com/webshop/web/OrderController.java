package com.webshop.web;

import com.webshop.model.Order;
import com.webshop.model.ShoppingCart;
import com.webshop.model.User;
import com.webshop.service.impl.OrderServiceImpl;
import com.webshop.service.impl.ShoppingCartServiceImpl;
import com.webshop.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {
    private final OrderServiceImpl orderService;
    private final ShoppingCartServiceImpl shoppingCartService;
    private final UserServiceImpl userService;

    public OrderController(OrderServiceImpl orderService, ShoppingCartServiceImpl shoppingCartService, UserServiceImpl userService) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }
    @GetMapping("/order")
    public String showOrder(Model model, HttpServletRequest req)
    {
        String username = req.getRemoteUser();
        User user = this.userService.SearchUser(username);
       // Order order= this.orderService.getOrder(user);
       // model.addAttribute("products",order.getShoppingCart().getProducts());
        model.addAttribute("user",user);
        return"Order.html";
    }
    @GetMapping("/order/{id}")
    public String addOrder(@PathVariable Long id, HttpServletRequest req)
    {
        String username = req.getRemoteUser();
        this.orderService.AddOrder(id,username);
        return "redirect:/order";
    }
}
