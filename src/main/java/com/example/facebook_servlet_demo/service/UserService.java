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

    public User accountLogin(String email, String password) {
        for (User user : findAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        String sql = "insert into user(name,email, password, image, sex, dob, address) values (?,?,?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getImage());
            preparedStatement.setString(5, user.getSex());
            preparedStatement.setString(6, user.getDob());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, User user) {
        String sql = "update user set name = ?,email = ?,password = ?, image = ?, sex = ?, dob = ?, address = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getImage());
            preparedStatement.setString(5, user.getSex());
            preparedStatement.setString(6, user.getDob());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setInt(8, id);
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
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String image = resultSet.getString("image");
                String sex = resultSet.getString("sex");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                User user = new User(id, name, email, password, image, sex, dob, address);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public User getById(int id) {
        User user = null;
        String sql = "select * from user where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String image = resultSet.getString("image");
                String sex = resultSet.getString("sex");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                user = new User(id, name, email, password, image, sex, dob,address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
