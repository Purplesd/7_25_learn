package com.iweb.service.impl;

import com.iweb.DAO.ProductDao;
import com.iweb.DAO.impl.ProductDaoImpl;
import com.iweb.pojo.Category;
import com.iweb.pojo.Product;
import com.iweb.service.ProductService;
import com.iweb.util.UUIDUtil;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> list(String category) {
        return productDao.list(category);
    }

    @Override
    public boolean addProduct(Product product) {
        if(productDao.verifyName(product.getName())){
            return false;
        }else {
            product.setId(UUIDUtil.uuid());
            return productDao.addProduct(product);
        }
    }
    @Override
    public boolean deleteProduct(String id) {
        return productDao.deleteProduct(id);
    }
    @Override
    public Product getProduct(String id) {
        return productDao.getProduct(id);
    }
    @Override
    public boolean update(Product product) {
        if(product.getCategory().equals("")){
            return false;
        }
        return productDao.update(product);
    }

    @Override
    public List<Product> search(List<Product>products,String name) {
        return productDao.search(products,name);
    }

    @Override
    public boolean purchase(String id) {
        Product product = productDao.getProduct(id);
        product.setStock(product.getStock()-1);
        return  productDao.update(product);
    }
}
