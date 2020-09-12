package com.tj.daoImpl;

import com.tj.dao.JUserDao;
import com.tj.daoutils.BaseDao;
import com.tj.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements JUserDao {
    @Override
    public int addUser(User user) throws Exception {
        String sql = "insert into user values(?,?,?,?)";
        Object[] params ={user.getUserid() , user.getUsername() , user.getUserpassword() ,user.getHeight()};
        int num = this.updateUser(sql , params);
        return num;
    }

    @Override
    public int removeUserById(int userid) throws Exception {
        String sql = "delete from user where userid=?";
        Object[] params = { userid };
        int num = this.updateUser(sql, params);
        return num;
    }

    @Override
    public int UpdatePasswordByUsername(User user) throws Exception {
        String sql = "update user set Userpassword=? where username=?";
        Object[] params = { user.getUserpassword(), user.getUsername() };
        int num = this.updateUser(sql, params);
        return num;
    }

    @Override
    public User login(User user) throws Exception {
        String sql = "select * from user where username=? and password=?";
        Object[] params = { user.getUsername(), user.getUserpassword() };
        List<User> userList = this.queryUser(sql, params);
        if (userList != null && userList.size() > 0) {
            // if (userList.size() > 0 && userList != null) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        String sql = "select * from user";
        Object[] params = {};
        List<User> userList = this.queryUser(sql, params);

        return userList;
    }

    @Override
    protected User getBean(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserid(resultSet.getInt(1));
        user.setUsername(resultSet.getString(2));
        user.setUserpassword(resultSet.getString(3));
        user.setHeight(resultSet.getInt(4));
        return user;
    }
}
