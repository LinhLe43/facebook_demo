package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "postController", value = "/posts")
public class PostController extends HttpServlet {
    private PostService postService = new PostService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "list":
                RequestDispatcher dispatcher = req.getRequestDispatcher("post/read.jsp");
                List<Post> posts = postService.findAll();
                req.setAttribute("posts", posts);
                dispatcher.forward(req, resp);
                break;
            case "create":
                RequestDispatcher dispatcher1 = req.getRequestDispatcher("post/create.jsp");
                dispatcher1.forward(req, resp);
                break;
            case "delete":
                RequestDispatcher dispatcher2 = req.getRequestDispatcher("post/delete.jsp");
                dispatcher2.forward(req, resp);
                break;
            case "update":
                RequestDispatcher dispatcher3 = req.getRequestDispatcher("post/update.jsp");
                dispatcher3.forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
