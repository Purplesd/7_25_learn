package com.iweb.DAO.impl;

import com.iweb.DAO.OrderDao;
import com.iweb.pojo.Category;
import com.iweb.pojo.Odpd;
import com.iweb.pojo.Order;
import com.iweb.pojo.Product;
import com.iweb.util.DBUtil;
import com.iweb.util.DruidUtil;
import com.iweb.util.UUIDUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public boolean generateOrder(Order order,List<Product> products) {
        String sql1="insert into `order` values(?,?,?)";
        String sql2="insert into odpd(pid,pname) values(?,?)";

        try {
            int count=qr.update(sql1,order.getId(),order.getPid(),order.getAddress());
            for (Product p: products) {
                if(count>0) {
                    count = qr.update(sql2, order.getPid(), p.getName());
                }
            }
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> list() {
        String sql="select * from `order`";
        try {
            List<Order> orders= qr.query(sql,new BeanListHandler<>(Order.class));
            return  orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> detail(String pid) {
        String sql1="select * from odpd where pid=?";
        String sql2="select * from product";
        List<Product> res = new ArrayList<>();
        try {
            List<Odpd> odpds= qr.query(sql1,new BeanListHandler<>(Odpd.class),pid);
            List<Product> products= qr.query(sql2,new BeanListHandler<>(Product.class));
            System.out.println(odpds);
            System.out.println(products);
            for (Product p: products) {
                for (Odpd o: odpds) {
                    if(p.getName().equals(o.getPname())){
                        res.add(p);
                    }
                }
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
