package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login/loginForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User account = userService.accountLogin(email, password);
        if (account == null) {
            resp.sendRedirect("/login");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
            resp.sendRedirect("/home");
        }
    }
}
