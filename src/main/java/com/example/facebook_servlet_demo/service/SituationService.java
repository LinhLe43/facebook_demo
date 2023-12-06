package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.Category;
import com.example.facebook_servlet_demo.model.Situation;
import com.example.facebook_servlet_demo.service.IService.ISituationService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SituationService implements ISituationService<Situation> {
    Connection connection = ConnectToMySQL.getConnection();
    @Override
    public void add(Situation situation) {

    }

    @Override
    public void edit(int id, Situation situation) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Situation> findAll() {
        List<Situation> situations = new ArrayList<>();
        String sql = "select * from situation";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Situation situation = new Situation(id, name);
                situations.add(situation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return situations;
    }
}
