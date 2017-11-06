/*
 * Copyright (c) 2017/9/13 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * JDBCDemo Create on 2017/9/13
 */
package top.zhaohaoren.JDBC;

import java.sql.*;

/**
 *
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {

//        jdbcMethod1();
        jdbcMethodNew();

    }

    private static void jdbcMethodNew() throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        Connection conn = null;
        try {
            //加载驱动  使用反射加载驱动，加载后内部static方法会自动注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接，第二种写法，常用的还是jdbcMethod1方法的那种
            //conn = DriverManager.getConnection("jdbc:mysql://10.211.55.3:3306/mydb1?user=root&password=0515")
            conn = DriverManager.getConnection("jdbc:mysql://10.211.55.3:3306/mydb1","root","0515");
            String sql =  "select * from t_user where uname=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"zhao"); //第一个占位符号---不支持中文？？
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //根据列名来取值，一般会存入一个对象中，数据库和类的映射
                System.out.println(rs.getObject("uname"));
                System.out.println(rs.getObject("uage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * 如此频繁的try catch就是为了防止程序在过程的某一处发生异常，那么前面占用的资源无法调用异常发生后的close方法
             * 导致没有释放资源！
             * */
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null; //让其可以GC

            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement = null;

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }

    }

    private static void jdbcMethod1() throws SQLException {
        // 注册驱动 -缺点：--new Driver()中又会注册一次驱动，这样就注册两次驱动了。
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 获取connection连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://10.211.55.3:3306/mydb1","root","0515");
        // 获取Statement对象,用于装载查询语句后返回结果。--操作sql语句的对象
        Statement statement = conn.createStatement();
        // Statement通过Connection将查询语句传递给数据库驱动，驱动执行并返回结果给java，java使用ResultSet来接受。
        ResultSet rs = statement.executeQuery("select * from t_user");
        // rs初始状态指向数据库查询结果第一行的前面一行。调用next获取第一行的数据。
        while (rs.next()){
            System.out.println(rs.getObject(1)); // 第一行第一列数据
            System.out.println(rs.getObject(2)); // 第一行第二列数据
        }

        //关闭三个资源
        rs.close();
        statement.close();
        conn.close();
    }
}
