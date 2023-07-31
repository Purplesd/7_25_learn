package com.iweb.service;

import com.iweb.pojo.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    boolean deleteProduct(String id);
    List<Product> list(String category);
    Product getProduct(String id);
    boolean update(Product product);
    List<Product> search(List<Product>products,String name);
    boolean purchase(String id);
}
