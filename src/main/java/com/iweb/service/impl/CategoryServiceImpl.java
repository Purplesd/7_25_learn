package com.iweb.service.impl;

import com.iweb.DAO.CategoryDao;
import com.iweb.DAO.ProductDao;
import com.iweb.DAO.impl.CategoryDaoImpl;
import com.iweb.DAO.impl.ProductDaoImpl;
import com.iweb.pojo.Category;
import com.iweb.pojo.Product;
import com.iweb.service.CategoryService;
import com.iweb.util.UUIDUtil;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Override
    public boolean delete(String id) {
        List<Product> products=productDao.list(categoryDao.get(id).getName());
        for (Product p: products) {
            if(!productDao.deleteProduct(p.getId())){
                return false;
            }
        }

        return categoryDao.delete(id);
    }

    @Override
    public boolean add(Category category) {
        if(categoryDao.verifyName(category.getName())){
            return false;
        }else {
            category.setId(UUIDUtil.uuid());
            return categoryDao.add(category);
        }
    }

    @Override
    public boolean verifyName(String name) {
        return categoryDao.verifyName(name);
    }
    @Override
    public boolean update(Category category) {
        for (Category c: categoryDao.list()) {
            if(!c.getId().equals(category.getId())
                    &&c.getName().equals(category.getName())){

                return false;
            }
        }
        return categoryDao.update(category);
    }
    @Override
    public Category get(String id) {
        return categoryDao.get(id);
    }
}
