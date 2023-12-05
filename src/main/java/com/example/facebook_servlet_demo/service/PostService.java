package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.Category;
import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.model.Situation;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.IService.IPostService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sql = "select p.*, c.name as categoryName, s.name as situationName, u.name as userName\n" +
                "from post p\n" +
                "         join category c on c.id = p.idCategory\n" +
                "         join situation s on p.idSituation = s.id\n" +
                "         join user u on p.idUser = u.id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                String time = resultSet.getString("time");
                int idSituation = resultSet.getInt("idSituation");
                int idCategory = resultSet.getInt("idCategory");
                int idUser = resultSet.getInt("idUser");
                String categoryName = resultSet.getString("categoryName");
                String situationName = resultSet.getString("situationName");
                String userName = resultSet.getString("userName");
                Category category = new Category(idCategory, categoryName);
                Situation situation = new Situation(idSituation, situationName);
                User user = new User(idUser, userName);
                Post post = new Post(id, content, image, time, situation, category, user);
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }

    @Override
    public Post getById(int id) {
        Post post = null;
        String sql = "select * from post where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                String time = resultSet.getString("time");
                int idSituation = resultSet.getInt("idSituation");
                int idCategory = resultSet.getInt("idCategory");
                int idUser = resultSet.getInt("idUser");
                Situation situation = new Situation(idSituation);
                Category category = new Category(idCategory);
                User user = new User(idUser);
                post = new Post(id, content, image, time, situation, category, user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return post;
    }
}