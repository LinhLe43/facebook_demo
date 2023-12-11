package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.Category;
import com.example.facebook_servlet_demo.model.Post;
import com.example.facebook_servlet_demo.model.Situation;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.CategoryService;
import com.example.facebook_servlet_demo.service.PostService;
import com.example.facebook_servlet_demo.service.SituationService;
import com.example.facebook_servlet_demo.service.UserService;

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
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "list":
                showList(req, resp);
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

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("post/read.jsp");
        List<Post> posts = postService.findAll();
        req.setAttribute("posts", posts);
        dispatcher.forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("post/createNewForm.jsp");
        List<Category> categories = categoryService.findAll();
        List<Situation> situations = situationService.findAll();
        req.setAttribute("categories", categories);
        req.setAttribute("situations", situations);
        dispatcher.forward(req, resp);
    }

    private void showView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("post/view.jsp");
        int idView = Integer.parseInt(req.getParameter("id"));
        Post viewPost = postService.getById(idView);
        req.setAttribute("post", viewPost);
        dispatcher.forward(req, resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("post/updateNewForm.jsp");
        int idUpdate = Integer.parseInt(req.getParameter("id"));
        Post updatePost = postService.getById(idUpdate);
        req.setAttribute("post", updatePost);
        List<Category> categories = categoryService.findAll();
        List<Situation> situations = situationService.findAll();
        req.setAttribute("categories", categories);
        req.setAttribute("situations", situations);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "search":
                RequestDispatcher dispatcher = req.getRequestDispatcher("post/searchResult.jsp");
                String name = req.getParameter("name");
                List<Post> posts = postService.getByUserName(name);
                req.setAttribute("posts", posts);
                List<User> users = userService.findAll();
                req.setAttribute("users", users);
                dispatcher.forward(req, resp);
                break;
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        resp.sendRedirect("/home");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idDelete = Integer.parseInt(req.getParameter("id"));
        postService.delete(idDelete);
        resp.sendRedirect("/posts?action=list");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUpdate = Integer.parseInt(req.getParameter("id"));
        String content = req.getParameter("content");
        String image = req.getParameter("image");
        String time = req.getParameter("time");
        int idSituation = Integer.parseInt(req.getParameter("idSituation"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        int idUser = Integer.parseInt(req.getParameter("idUser"));
        Situation situation = new Situation(idSituation);
        Category category = new Category(idCategory);
        User user = new User(idUser);
        Post updatePost = new Post(content, image, time, situation, category, user);
        postService.edit(idUpdate, updatePost);
        resp.sendRedirect("/home");
    }
}
