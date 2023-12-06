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
    String sql = " insert into comment (time, content, image, idPost, idUser) value (?, ? ,?,? ,?);";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,comment.getDate());
        preparedStatement.setString(2,comment.getContent());
        preparedStatement.setString(3,comment.getImage());
        preparedStatement.setInt(4,comment.getPost().getId());
        preparedStatement.setInt(5,comment.getUser().getId());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @Override
    public void edit(int id, Comment comment) {
     String sql = "update comment set idUser=?,time =? ,content =? ,image=?  where id=?";
     try {
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setInt(1,comment.getUser().getId());
         preparedStatement.setString(2, comment.getDate());
         preparedStatement.setString(3, comment.getContent());
         preparedStatement.setString(4, comment.getImage());
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
        String sql = "select c.* ,u.name as nameUser  from comment c join user u on u.id = c.idPost join post p on c.idPost = p.id order by c.id ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String time = resultSet.getString("time");
                System.out.println(time);
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                int idPost = resultSet.getInt("idPost");
                int idUser = resultSet.getInt("idUser");
                String userName = resultSet.getString("nameUser");
                Post post = new Post(idPost);
                User user = new User(idUser, userName);
                Comment comment = new Comment(id ,time,content,image,post,user);
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
        String sql = "select c.* ,u.name as nameUser from comment c join user u on u.id = c.idPost join post p on c.idPost = p.id where p.id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String time = resultSet.getString("time");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                int idPost = resultSet.getInt("idPost");
                int idUser = resultSet.getInt("idUser");
                String userName = resultSet.getString("nameUser");
                Post post = new Post(idPost);
                User user = new User(idUser, userName);
                comment = new Comment(time,content,image,post,user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comment;
    }
}
