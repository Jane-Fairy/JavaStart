package com.tj.daoutils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class DaoUtils {

    private static String Driver;
    private static String url;
    private static String user;
    private static String pwd;
    private static int max = 0;


    //创建储存connection对象的容器
    private static List<Connection> conPool = new LinkedList<>();

    // 初始化获取数据库驱动,初始化生成数据库连接池，向里面添加max个数据库连接对象
    static {
        try {
            load();
            Class.forName(Driver);
            for (int i = 0; i < max; i++) {
                Connection connection = DriverManager.getConnection(url, user, pwd);
                conPool.add(connection);
            }
        } catch (Exception e) {
            System.err.println("错误");
        }
    }

    //创建获取数据库连接对象Connection方法
    public static synchronized  Connection getCon() throws SQLException {
        Connection conn = null;
        //先判断是否有Conncetion对象在容器中，如果数据库容器池中有Connection，则将conPool的最后一个对象给conn，否则在创建一个Connection对象
        if (conPool != null && conPool.size() > 0){
            conn = conPool.get(conPool.size() - 1);
        }else {
            conn = DriverManager.getConnection(url ,user ,pwd);
        }
        return  conn;
    }

    //关闭所有连接
    public static int CloseAll(Connection c , PreparedStatement ps ,ResultSet rs) throws SQLException {
        if (c == null) {
            c.close();
        }
        if (ps == null) {
            ps.close();
        }
        if (rs == null) {
            rs.close();
        }
        return 1;
    }

    //加载配置文件信息
    public static void load(){
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        try {
            Driver = bundle.getString("driver");
            System.out.println(Driver);
            url = bundle.getString("url");
            user = bundle.getString("user");
            pwd = bundle.getString("pwd");
            max = Integer.parseInt(bundle.getString("max"));
        } catch (Exception e) {
            System.out.println("读取失败");
            Driver = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
            user = "root";
            pwd = "root";
            max = 10;
        }
    }

}

