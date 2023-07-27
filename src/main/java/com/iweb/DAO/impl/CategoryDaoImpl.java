package com.iweb.DAO.impl;

import com.iweb.DAO.CategoryDao;
import com.iweb.pojo.Category;
import com.iweb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Category> list() {
        String sql="select * from category";
        try {
            List<Category> categories= qr.query(sql,new BeanListHandler<>(Category.class));
            return  categories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Category category) {
        String sql="insert into category values(?,?)";
        try {
            int count=qr.update(sql,category.getId(),category.getName());
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql="delete from category where id=?";
        try {
            int count=qr.update(sql,id);
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        String sql = "update category set name=? where id=?";
        try {
            int count=qr.update(sql,category.getName(),category.getId());
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category get(String id) {
        String sql = "select * from category where id=?";
        Category category=null;
        try {
            category = qr.query(sql,new BeanHandler<>(Category.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    @Override
    public boolean verifyName(String name) {
        String sql = "select count(*) from category where name=?";
        try {
            Number number= (Number) qr.query(sql,new ScalarHandler<>(),name);
            return  number.intValue()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
