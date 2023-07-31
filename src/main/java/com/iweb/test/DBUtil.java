package com.iweb.test;

import java.sql.Connection;
import java.sql.DriverManager;

@DB(driverClassName ="com.mysql.jdbc.Driver",url = "jdbc:mysql://localhost:3306/iweb?characterEncoding=utf8"
        ,username ="root",password = "root")
public class DBUtil {
    public static Connection getConn() throws Exception {
        DB db = DBUtil.class.getAnnotation(DB.class);
        String dn=db.driverClassName();
        String url=db.url();
        String un=db.username();
        String pw=db.password();

            Class.forName(dn);
            Connection c = DriverManager.getConnection(url,un,pw);
            return c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConn());
    }
}
