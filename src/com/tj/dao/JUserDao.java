package com.tj.dao;

import com.tj.entity.User;

import java.util.List;

public interface JUserDao {
    int addUser(User user) throws Exception;

    int removeUserById(int userid) throws Exception;

    int UpdatePasswordByUsername(User user) throws Exception;

    User login(User user) throws Exception;

    List<User> getAllUsers() throws Exception;
}
