package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.Comment;
import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.CommentService;
import com.example.facebook_servlet_demo.service.ConnectToMySQL;
import com.example.facebook_servlet_demo.service.PostService;
import com.example.facebook_servlet_demo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "commentController", value = "/comments")
public class CommentController extends HttpServlet {
    Connection connection = ConnectToMySQL.getConnection();
    private CommentService commentService = new CommentService();
    private PostService postService = new PostService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "list":
                showListComment(req,resp);
                break;
            case "create":
                showCreate(req, resp);
                break;
            case "update":
                showUpdate(req, resp);
                break;
            case "view":
                showView(req, resp);
                break;

        }

    }

    private void showListComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("comment/read.jsp");
        List<Comment> comments = commentService.findAll();
        req.setAttribute("comments", comments);
        dispatcher.forward(req, resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException

    {
        RequestDispatcher dispatcher = req.getRequestDispatcher("comment/update.jsp");
        int idUpdate = Integer.parseInt(req.getParameter("id"));
        Comment updateComment = commentService.getById(idUpdate);
        req.setAttribute("comment", updateComment);
        dispatcher.forward(req, resp);
    }

    private void showView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException

    {
        RequestDispatcher dispatcher = req.getRequestDispatcher("comment/read.jsp");
        List<Comment> comments = commentService.findAll();
        req.setAttribute("comments", comments);
        dispatcher.forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException

    {
        RequestDispatcher dispatcher = req.getRequestDispatcher("comment/create.jsp");
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        req.setAttribute("idPost", idPost);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String action = req.getParameter("action");
           switch (action){
               case "create":
                   create(req, resp);
                   break;
               case "delete":
                   delete(req, resp);
                   break;
               case "update":
                   update(req, resp);
                   break;
           }
    }
    private void create (HttpServletRequest req, HttpServletResponse resp) throws  IOException{
        String time = req.getParameter("time");
        String content = req.getParameter("content");
        String image = req.getParameter("image");
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        Post post = new Post(idPost);
        User user = new User(idUser);
        Comment newComment = new Comment(content,image,time,post,user);
        commentService.add(newComment);
        resp.sendRedirect("/comments?action=list");
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idDelete = Integer.parseInt(req.getParameter("id"));
        postService.delete(idDelete);
        resp.sendRedirect("/comments?action=list");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        int idUpdate = Integer.parseInt(req.getParameter("id"));
        String time = req.getParameter("time");
        String content = req.getParameter("content");
        String image = req.getParameter("image");
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        Post post = new Post(idPost);
        User user = new User(idUser);
        Comment updateComment = new Comment(time,content,image,post,user);
        commentService.edit(idUpdate,updateComment);
        resp.sendRedirect("/commnets?action=list");
    }
}
