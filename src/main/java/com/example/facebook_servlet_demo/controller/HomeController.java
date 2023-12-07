package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.PostService;
import com.example.facebook_servlet_demo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeController", value = "/home")
public class HomeController extends HttpServlet {
    private UserService userService = new UserService();
    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("home/home.jsp");
        List<User> users = userService.findAll();
        req.setAttribute("users", users);
        List<Post> posts = postService.findAll();
        req.setAttribute("posts", posts);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}