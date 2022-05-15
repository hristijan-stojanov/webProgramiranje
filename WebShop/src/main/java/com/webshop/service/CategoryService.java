package com.webshop.service;

import com.webshop.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);

    List<Category> listAll();

    Category create(String name);
}
