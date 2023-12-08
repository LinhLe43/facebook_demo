package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userController", value = "/users")
public class UserController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "list":
                showListUser(req, resp);
                break;
            case "create":
                showFormAdd(req, resp);
                break;
            case "update":
                showFormUpdate(req, resp);
                break;
        }
    }

    private void showListUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/read.jsp");
        List<User> users = userService.findAll();
        req.setAttribute("users", users);
        dispatcher.forward(req, resp);
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/update.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getById(id);
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "update":
                update(req, resp);
                break;

        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String image = req.getParameter("image");
        String sex = req.getParameter("sex");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        User user = new User(name, email, password, image, sex, dob, address);
        userService.add(user);
        resp.sendRedirect("/login");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String image = req.getParameter("image");
        String sex = req.getParameter("sex");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        User user = new User(name, email, password, image, sex, dob, address);
        userService.edit(id, user);
        resp.sendRedirect("/users?action=list");
    }
}
