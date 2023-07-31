package com.iweb.DAO.impl;

import com.iweb.DAO.ProductDao;
import com.iweb.pojo.Category;
import com.iweb.pojo.Product;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Product> list(String category) {
        String sql="select * from product where category=?";
        try {
            List<Product> products= qr.query(sql,new BeanListHandler<>(Product.class),category);
            return  products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        String sql="insert into product values(?,?,?,?,?)";
        try {
            int count=qr.update(sql,product.getId(),product.getName(),
                    product.getPrice(),product.getStock(),product.getCategory());
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean verifyName(String name) {
        String sql = "select count(*) from product where name=?";
        try {
            Number number= (Number) qr.query(sql,new ScalarHandler<>(),name);
            return  number.intValue()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        String sql="delete from product where id=?";
        try {
            int count=qr.update(sql,id);
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getProduct(String id) {
        String sql = "select * from product where id=?";
        Product product=null;
        try {
            product = qr.query(sql,new BeanHandler<>(Product.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        String sql = "update product set name=?,price=?,stock=?,category=? where id=?";
        try {
            int count=qr.update(sql,product.getName(),product.getPrice(),product.getStock()
                    ,product.getCategory(),product.getId());
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> search(List<Product>products,String name) {
        String sql="SELECT * from product where name like concat('%',?,'%')";
        try {
            List<Product> products2= qr.query(sql,new BeanListHandler<>(Product.class),name);
            products.retainAll(products2);
            return  products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
