package com.iweb.service;

import com.iweb.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    boolean delete(String id);
    boolean add(Category category);
    boolean verifyName(String name);
    boolean update(Category category);
    Category get(String id);
}
