package com.webshop.service.impl;

import com.webshop.model.Product;
import com.webshop.model.ShoppingCart;
import com.webshop.model.User;
import com.webshop.model.exceptions.InvalidUserException;
import com.webshop.repository.ProductRepository;
import com.webshop.repository.ShoppingCartRepository;
import com.webshop.repository.UserRepository;
import com.webshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductServiceImpl productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductServiceImpl productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;

    }

    @Override
    public ShoppingCart findById(Long id) {
        return this.shoppingCartRepository.getById(id);
    }

    @Override
    public List<Product> listAllProducts(Long id) {
        ShoppingCart shoppingCart= this.findById(id);
        List<Product> products=shoppingCart.getProducts();
        return products;
    }

    @Override
    public ShoppingCart addProduct(String username, Long productId) {
        User user= this.userRepository.findByUsername(username).orElseThrow(InvalidUserException::new);
       ShoppingCart shoppingCart=this.shoppingCartRepository.findByUser(user);
        Product product= this.productService.findById(productId);

       if(shoppingCart == null)
        {
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setUser(user);
        shoppingCart1.getProducts().add(product);
         this.shoppingCartRepository.save(shoppingCart1);
            return shoppingCart1;
        }else {
           shoppingCart.getProducts().add(product);
           this.shoppingCartRepository.save(shoppingCart);
       }

        return shoppingCart;
    }

    @Override
    public ShoppingCart getShoppingCart(User user) {
         return this.shoppingCartRepository.findByUser(user);
    }

    @Override
    public ShoppingCart deletProduct(ShoppingCart shoppingCart, Long id) {
        Product product=this.productService.findById(id);
        shoppingCart.getProducts().remove(product);

        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart delet(ShoppingCart shoppingCart) {

        List<Product> products= this.listAllProducts(shoppingCart.getId());
        shoppingCart.getProducts().removeAll(products);

        return this.shoppingCartRepository.save(shoppingCart);
    }
}
