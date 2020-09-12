package com.tj.service;

import com.tj.daoImpl.UserDaoImpl;
import com.tj.entity.User;

public class UserService {
    private static final UserDaoImpl userDao = new UserDaoImpl();

    public int addUser(User user) throws Exception {
        if (user.getHeight() < 0 || user.getHeight() > 200) {
            user.setHeight(120);
        }
        return userDao.addUser(user);
    }

    public int removeUserById(int userid) throws Exception {

        return userDao.removeUserById(userid);
    }

    public int UpdatePasswordByUsername(User user) throws Exception {
        if (user.getUserpassword().length() <= 2 || user.getUserpassword().length() > 16) {
            System.err.println("密码2-16位之间");
            return 0;
        }
        return userDao.UpdatePasswordByUsername(user);

    }
}
