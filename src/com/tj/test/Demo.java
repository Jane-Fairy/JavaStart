package com.tj.test;

import com.tj.dao.JUserDao;
import com.tj.daoImpl.UserDaoImpl;
import com.tj.entity.User;
import com.tj.service.UserService;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws Exception {

        /**
         * 添加用户
         */
//        Scanner sc = new Scanner(System.in);
//        System.out.println("用户ID");
//        int userid = sc.nextInt();
//        System.out.println("用户名");
//        String username = sc.next();
//        System.out.println("用户密码");
//        String userpassword = sc.next();
//        System.out.println("用户身高");
//        int height = sc.nextInt();
//
          User user = new User();
//        user.setHeight(height);
//        user.setUserpassword(userpassword);
//        user.setUsername(username);
//        user.setUserid(userid);
//        int num = new UserService().addUser(user);
//        System.out.println(num);

        //修改用户密码

        /**
         *删除用户
         */
          Scanner sc = new Scanner(System.in);
//        System.out.println("请输入要删除的用户id");
//        int id = sc.nextInt();
//        user.setUserid(id);
//        int num = new UserDaoImpl().removeUserById(id);
//        System.out.println(num);

        /**
         * 修改用户密码
         */
        System.out.println("请输入要更改密码的用户名username");
        String username = sc.next();
        System.out.println("请输入新的密码");
        String password = sc.next();
        user.setUsername(username);
        user.setUserpassword(password);
        int num = new UserDaoImpl().UpdatePasswordByUsername(user);
        System.out.println(num);


    }
}
