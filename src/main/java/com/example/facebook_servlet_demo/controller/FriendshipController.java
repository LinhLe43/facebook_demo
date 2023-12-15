package com.example.facebook_servlet_demo.controller;

import com.example.facebook_servlet_demo.model.FriendShip;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.FriendShipService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "friendshipController", value = "/friendships")
public class FriendshipController extends HttpServlet {
    private FriendShipService friendShipService = new FriendShipService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                int idAccount = Integer.parseInt(req.getParameter("idAccount"));
                int idUser = Integer.parseInt(req.getParameter("idUser"));
                User user1 = new User(idAccount);
                User user2 = new User(idUser);
                FriendShip friendShip = new FriendShip(user1, user2);
                friendShipService.add(friendShip);
                resp.sendRedirect("/home");
                break;
        }
    }
}
