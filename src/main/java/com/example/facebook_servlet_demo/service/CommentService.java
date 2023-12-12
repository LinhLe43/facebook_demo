package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.Comment;
import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.IService.ICommentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentService implements ICommentService<Comment> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Comment comment) {
        String sql = "insert into comment(time, content, idPost, idUser)\n" +
                "values (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, comment.getTime());
            preparedStatement.setString(2, comment.getContent());
            preparedStatement.setInt(3, comment.getPost().getId());
            preparedStatement.setInt(4, comment.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Comment comment) {
        String sql = "update comment\n" +
                "set time    = ?,\n" +
                "    content = ?,\n" +
                "    idPost  = ?,\n" +
                "    idUser  = ?\n" +
                "where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, comment.getTime());
            preparedStatement.setString(2, comment.getContent());
            preparedStatement.setInt(3, comment.getPost().getId());
            preparedStatement.setInt(4, comment.getUser().getId());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete  from comment where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        String sql = "select c.*, u.name as nameUser, u.image as imageUser\n" +
                "from comment c\n" +
                "         join user u on u.id = c.idUser";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String time = resultSet.getString("time");
                String content = resultSet.getString("content");
                int idPost = resultSet.getInt("idPost");
                Post post = new Post(idPost);
                int idUser = resultSet.getInt("idUser");
                String nameUser = resultSet.getString("nameUser");
                String imageUser = resultSet.getString("imageUser");
                User user = new User(idUser, nameUser, imageUser);
                Comment comment = new Comment(id, content, time, post, user);
                comments.add(comment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comments;
    }

    @Override
    public Comment getById(int id) {
        Comment comment = null;
        String sql = "select c.*, u.name as nameUser, u.image as imageUser\n" +
                "from comment c\n" +
                "         join user u on u.id = c.idUser\n" +
                "where c.id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String time = resultSet.getString("time");
                String content = resultSet.getString("content");
                int idPost = resultSet.getInt("idPost");
                Post post = new Post(idPost);
                int idUser = resultSet.getInt("idUser");
                String nameUser = resultSet.getString("nameUser");
                String imageUser = resultSet.getString("imageUser");
                User user = new User(idUser, nameUser, imageUser);
                comment = new Comment(id, content, time, post, user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comment;
    }
}
