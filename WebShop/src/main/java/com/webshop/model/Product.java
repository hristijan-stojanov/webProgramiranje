package com.webshop.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    Long Id;
    String productName;
    String ProductImage;
    String ProductDescription;
    double ProductPrice;
    double ProductRating;
    @ManyToOne
    Category productCategory;

    public Product() {
    }

    public Product(String productName, String productImage, String productDescription, double productPrice, double productRating,Category productCategory) {
        this.productName = productName;
        ProductImage = productImage;
        ProductDescription = productDescription;
        ProductPrice = productPrice;
        ProductRating = productRating;
        this.productCategory=productCategory;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public void setProductRating(double productRating) {
        ProductRating = productRating;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Long getId() {
        return Id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public double getProductRating() {
        return ProductRating;
    }

    public Category getProductCategory() {
        return productCategory;
    }
}
