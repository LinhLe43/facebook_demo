package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.service.IService.IPostService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostService implements IPostService<Post> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Post post) {
        String sql = "insert into post(content, image, time, idSituation, idCategory, idUser)\n" +
                "values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, post.getContent());
            preparedStatement.setString(2, post.getImage());
            preparedStatement.setString(3, post.getTime());
            preparedStatement.setInt(4, post.getSituation().getId());
            preparedStatement.setInt(5, post.getCategory().getId());
            preparedStatement.setInt(6, post.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Post post) {
        String sql = "update post\n" +
                "set content     = ?,\n" +
                "    image       = ?,\n" +
                "    time        = ?,\n" +
                "    idSituation = ?,\n" +
                "    idCategory  = ?,\n" +
                "    idUser      = ?\n" +
                "where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, post.getContent());
            preparedStatement.setString(2, post.getImage());
            preparedStatement.setString(3, post.getTime());
            preparedStatement.setInt(4, post.getSituation().getId());
            preparedStatement.setInt(5, post.getCategory().getId());
            preparedStatement.setInt(6, post.getUser().getId());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from post where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();

        return posts;
    }

}
