package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.Category;
import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.model.Situation;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.CategoryService;
import com.example.facebook_servlet_demo.service.PostService;
import com.example.facebook_servlet_demo.service.SituationService;

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
    private CategoryService categoryService = new CategoryService();
    private SituationService situationService = new SituationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "list":
                showList(req, resp);
                break;
            case "create":
                RequestDispatcher dispatcher1 = req.getRequestDispatcher("post/create.jsp");
                List<Category> categories = categoryService.findAll();
                List<Situation> situations = situationService.findAll();
                req.setAttribute("categories", categories);
                req.setAttribute("situations", situations);
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

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("post/read.jsp");
        List<Post> posts = postService.findAll();
        req.setAttribute("posts", posts);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                String content = req.getParameter("content");
                String image = req.getParameter("image");
                String time = req.getParameter("time");
                int idSituation = Integer.parseInt(req.getParameter("idSituation"));
                int idCategory = Integer.parseInt(req.getParameter("idCategory"));
                int idUser = Integer.parseInt(req.getParameter("idUser"));
                Situation situation = new Situation(idSituation);
                Category category = new Category(idCategory);
                User user = new User(idUser);
                Post newPost = new Post(content, image, time, situation, category, user);
                postService.add(newPost);
                resp.sendRedirect("/posts?action=list");
                break;
        }
    }
}
