package com.webshop.web;

import com.webshop.model.Category;
import com.webshop.model.Product;
import com.webshop.service.impl.CategoryServiceImpl;
import com.webshop.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchProductController {
    private final ProductServiceImpl productService;
    private final CategoryServiceImpl categoryService;

    public SearchProductController(ProductServiceImpl productService, CategoryServiceImpl categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @PostMapping("/search")
    public String InputSearch(@PathVariable(required = false) Long id ,@RequestParam(required = false) String name, Model model)
    {
        List<Product> products;
        if(name != null)
        {
            products= this.productService.listProductsByName(name);
        }else
        {
            Category category = this.categoryService.findById(id);
             products= this.productService.listProductsByCategory(category);
        }

        List<Category> categorys = this.categoryService.listAll();
        model.addAttribute("categorys", categorys);
        model.addAttribute("products",products);
        return "Home.html";
    }
    @GetMapping("/searchCategory/{id}")
    public String CategorySearch(@PathVariable Long id ,Model model)
    {
        Category category = this.categoryService.findById(id);
        List<Product> products= this.productService.listProductsByCategory(category);
        List<Category> categorys = this.categoryService.listAll();
        model.addAttribute("categorys", categorys);
        model.addAttribute("products",products);
        return "Home.html";

    }
}
