package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.Comment;
import com.example.facebook_servlet_demo.service.IService.ICommentService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CommentService implements ICommentService<Comment> {

    @Override
    public void add(Comment comment) {
        String sql = "insert into category(id, name, ) values (?, ?)";
    }

    @Override
    public void edit(int id, Comment comment) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Comment> findAllComment() {
        return null;
    }
}
