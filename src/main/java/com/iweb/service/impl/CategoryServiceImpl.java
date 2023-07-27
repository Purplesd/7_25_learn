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
}
