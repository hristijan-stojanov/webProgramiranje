package com.webshop.service.impl;

import com.webshop.model.Category;
import com.webshop.model.Product;
import com.webshop.model.exceptions.InvalidProductException;
import com.webshop.repository.ProductRepository;
import com.webshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private  final CategoryServiceImpl categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryServiceImpl categoryService) {
        this.productRepository = productRepository;

        this.categoryService = categoryService;
    }

    @Override
    public List<Product> listAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(InvalidProductException::new);
    }

    @Override
    public Product create(String productName, String productImage, String productDescription, double productPrice, double productRating, Long productCategory)
    {
        Category category= this.categoryService.findById(productCategory);
        Product product= new Product(productName,productImage,productDescription,productPrice,productRating,category);

        return this.productRepository.save(product);
    }


    @Override
    public Product update(Long id, String productName, String productImage, String productDescription, double productPrice, double productRating, Long productCategory) {
        Product product= this.findById(id);
       product.setProductName(productName);
       product.setProductImage(productImage);
       product.setProductDescription(productDescription);
       product.setProductPrice(productPrice);
       product.setProductRating(productRating);
        Category category= this.categoryService.findById(productCategory);
       product.setProductCategory(category);
        return this.productRepository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Product product= this.findById(id);
        this.productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> listProductsByName(String productName)
    {
        return this.productRepository.findByProductNameLike("%"+productName+"%");
    }

    @Override
    public List<Product> listProductsByCategory(Category category) {
        return this.productRepository.findByProductCategoryIs(category);
    }
}
