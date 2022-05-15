package com.webshop.service;

import com.webshop.model.Category;
import com.webshop.model.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    Product findById(Long id);
    Product create(String productName, String productImage, String productDescription, double productPrice, double productRating,Long productCategory);


    Product update(Long id, String productName, String productImage, String productDescription, double productPrice, double productRating, Long productCategory);

    Product delete(Long id);
    List<Product> listProductsByName(String productName);
    List<Product> listProductsByCategory(Category category);
}
