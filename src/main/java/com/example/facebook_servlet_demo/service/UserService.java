package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.IService.IUserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "insert into user(name, profile_picture, sex, dob, address) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getImage());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, user.getDob());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, User user) {
        String sql = "update user set name = ?, profile_picture = ?, sex = ?, dob = ?, address = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getImage());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, user.getDob());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        return null;
    }
}
