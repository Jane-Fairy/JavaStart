package com.tj.daoutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {
    //判断who使用数据库
    protected abstract T getBean(ResultSet resultSet) throws SQLException;

    //更新数据库信息的方法:updateUser
    public int updateUser(String sql, Object[] params) throws Exception {
        Connection connection = DaoUtils.getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        int num = preparedStatement.executeUpdate();
        return num;
    }

    //查询数据库数据
    public List<T> queryUser (String sql , Object[] params) throws Exception{
        Connection connection = DaoUtils.getCon();
        List<T> list = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            T t = this.getBean(resultSet);
            list.add(t);
        }
        DaoUtils.CloseAll(connection ,preparedStatement , resultSet);
        return  list;
    }
}
