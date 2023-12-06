package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.Category;
import com.example.facebook_servlet_demo.service.IService.ICategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService<Category> {
    Connection connection = ConnectToMySQL.getConnection();
    @Override
    public void add(Category category) {

    }

    @Override
    public void edit(int id, Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Category> findAll() {
        return null;
    }

}
