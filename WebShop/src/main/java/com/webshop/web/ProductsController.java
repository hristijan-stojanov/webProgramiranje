package com.webshop.web;

import com.webshop.model.Category;
import com.webshop.model.Product;
import com.webshop.service.impl.CategoryServiceImpl;
import com.webshop.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductServiceImpl productService;
    private final CategoryServiceImpl categoryService;

    public ProductsController(ProductServiceImpl productService, CategoryServiceImpl categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @GetMapping
    public String showProducts(@RequestParam (required = false) String name, Model model) {
        List<Product> products;
        if(name!=null)
        {
            products= this.productService.listProductsByName(name);
        }else
        {
           products= this.productService.listAllProducts();
        }

        List<Category> categorys = this.categoryService.listAll();
        model.addAttribute("categorys", categorys);
        model.addAttribute("products",products);
        return "Home.html";
    }
    @GetMapping("/add")
    public String showAdd(Model model) {
        List<Category> category= this.categoryService.listAll();
        model.addAttribute("categories",category);
        return "AddForm.html";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Product product = this.productService.findById(id);
        List<Category> category= this.categoryService.listAll();
        model.addAttribute("product",product);
        model.addAttribute("categories",category);

        return "AddForm.html";
    }

    @PostMapping("/add")
    public String create(@RequestParam (required = false) Long id,
                         @RequestParam  String productName,
                         @RequestParam  String productImage,
                         @RequestParam   String productDescription,
                         @RequestParam   double productPrice,
                         @RequestParam   double productRating,
                         @RequestParam  Long productCategory) {
        if(id!=null)
        {
            this.productService.update(id,productName,productImage,productDescription,productPrice,productRating,productCategory);
        }else {
            this.productService.create(productName, productImage, productDescription, productPrice, productRating, productCategory);
        }
        return "redirect:/products";
    }
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String productName,
                         @RequestParam String productImage,
                         @RequestParam String productDescription,
                         @RequestParam double productPrice,
                         @RequestParam double productRating,
                         @RequestParam Long productCategory) {
        this.productService.update(id, productName, productImage, productDescription,productPrice,productRating,  productCategory);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable  Long id) {
        this.productService.delete(id);
        return "redirect:/products";
    }

}
