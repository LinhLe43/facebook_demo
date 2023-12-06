package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.IService.IUserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService<User> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public User checkLogin(String name, String password) {
        String sql = "select name, password\n" +
                "from user\n" +
                "where name = ?\n" +
                "  and password = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User account = new User(resultSet.getString("name"), resultSet.getString("password"));
                return account;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void edit(int id, User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
