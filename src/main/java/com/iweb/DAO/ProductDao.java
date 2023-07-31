package com.iweb.DAO;

import com.iweb.pojo.Category;
import com.iweb.pojo.Product;

import java.util.List;

public interface ProductDao {
    List<Product> list(String category);
    boolean addProduct(Product product);
    boolean verifyName(String name);
    boolean deleteProduct(String id);
    Product getProduct(String id);
    boolean update(Product product);
    List<Product> search(List<Product>products,String name);
}
