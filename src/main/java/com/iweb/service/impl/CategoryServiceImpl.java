package com.iweb.service.impl;

import com.iweb.DAO.CategoryDao;
import com.iweb.DAO.impl.CategoryDaoImpl;
import com.iweb.pojo.Category;
import com.iweb.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Override
    public boolean delete(String id) {
        return categoryDao.delete(id);
    }

    @Override
    public boolean add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public boolean verifyName(String name) {
        return categoryDao.verifyName(name);
    }
    @Override
    public boolean update(Category category) {
        return categoryDao.update(category);
    }
    @Override
    public Category get(String id) {
        return categoryDao.get(id);
    }
}
