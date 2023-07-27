package com.iweb.DAO;

import com.iweb.pojo.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> list();
    boolean add(Category category);
    boolean delete(String id);
    boolean update(Category category);
    Category get(String id);
}
