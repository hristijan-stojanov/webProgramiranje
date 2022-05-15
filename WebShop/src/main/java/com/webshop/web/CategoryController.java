package com.webshop.web;

import com.webshop.model.Category;
import com.webshop.service.impl.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public String showCategory(Model model)
    {
        List<Category> categorys= this.categoryService.listAll();
        model.addAttribute("categorys", categorys);
        return "listCategory.html";
    }
    @GetMapping("/add")
    public String showAdd() {

        return "AddCategory.html";
    }
    @PostMapping("/add")
    public String create(@RequestParam String name)
    {
        this.categoryService.create(name);
        return "redirect:/products";
    }
}
