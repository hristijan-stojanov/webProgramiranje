package com.webshop.repository;



import com.webshop.model.Category;
import com.webshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByProductNameLike(@Param("productName") String productName);
    List<Product> findByProductCategoryIs(Category category);
}
