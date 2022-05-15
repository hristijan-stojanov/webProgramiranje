package com.webshop.web;

import com.webshop.model.Product;
import com.webshop.model.ShoppingCart;
import com.webshop.model.User;
import com.webshop.service.impl.ProductServiceImpl;
import com.webshop.service.impl.ShoppingCartServiceImpl;
import com.webshop.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShoppingCartController {
    private final ShoppingCartServiceImpl shoppingCartService;
    private final UserServiceImpl userService;
    private  final ProductServiceImpl productService;

    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService, UserServiceImpl userService, ProductServiceImpl productService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.productService = productService;
    }
    @GetMapping("/shoppingcart")
    public String showShoppingCart(Model model, HttpServletRequest req)
    {
        String username = req.getRemoteUser();
        User user = this.userService.SearchUser(username);
        ShoppingCart shoppingCart= this.shoppingCartService.getShoppingCart(user);
        List<Product> products =this.shoppingCartService.listAllProducts(shoppingCart.getId());
        model.addAttribute("products",products);
        model.addAttribute("cart",shoppingCart);
     return "ShoppingCart.html";
    }
    @GetMapping("/shoppingcart/{id}")
    public String AddProductInShoppingCart(@PathVariable Long id,HttpServletRequest req)
    {
        String username = req.getRemoteUser();
         this.shoppingCartService.addProduct(username,id);
         return "redirect:/products";
    }
    @GetMapping("/shoppingcart/delet/{id}")
    public String DeletProduct(@PathVariable Long id,HttpServletRequest req)

    {
        String username = req.getRemoteUser();
        User user = this.userService.SearchUser(username);
        ShoppingCart shoppingCart= this.shoppingCartService.getShoppingCart(user);
        this.shoppingCartService.deletProduct(shoppingCart,id);
        return "redirect:/shoppingcart";
    }
    @GetMapping("orderr")
    public String Order(Model model,HttpServletRequest req)
    {
        String username = req.getRemoteUser();
        User user = this.userService.SearchUser(username);
        ShoppingCart shoppingCart= this.shoppingCartService.getShoppingCart(user);
        List<Product> products =this.shoppingCartService.listAllProducts(shoppingCart.getId());
        model.addAttribute("products",products);
        model.addAttribute("user",user);
        //this.shoppingCartService.delet(shoppingCart);
        return "Order.html";

    }
}
