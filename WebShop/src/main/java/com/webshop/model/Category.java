package com.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    Long id;
     String CategotyName;

    public Category(String categotyName) {
        CategotyName = categotyName;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getCategotyName() {
        return CategotyName;
    }
}
