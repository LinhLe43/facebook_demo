package com.example.facebook_servlet_demo.service;

import com.example.facebook_servlet_demo.model.FriendShip;
import com.example.facebook_servlet_demo.model.User;
import com.example.facebook_servlet_demo.service.IService.IFriendShipService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendShipService implements IFriendShipService<FriendShip> {
    Connection connection = ConnectToMySQL.getConnection();
    @Override
    public void add(FriendShip friendShip) {

    }

    @Override
    public List<FriendShip> findAll() {
        List<FriendShip> friendShips = new ArrayList<>();
        String sql = "select f.*,\n" +
                "       u1.name  as first_User_Name,\n" +
                "       u1.image as first_User_Image,\n" +
                "       u2.name  as second_User_Name,\n" +
                "       u2.image as second_User_Image\n" +
                "from friendship f\n" +
                "         join user u1 on u1.id = f.idUser1\n" +
                "         join user u2 on u2.id = f.idUser2";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idUser1 = resultSet.getInt("idUser1");
                int idUser2 = resultSet.getInt("idUser2");
                String first_User_Name = resultSet.getString("first_User_Name");
                String second_User_Name = resultSet.getString("second_User_Name");
                String first_User_Image = resultSet.getString("first_User_Image");
                String second_User_Image = resultSet.getString("second_User_Image");
                User user1 = new User(idUser1, first_User_Name, first_User_Image);
                User user2 = new User(idUser2, second_User_Name, second_User_Image);
                FriendShip friendShip = new FriendShip(id, user1, user2);
                friendShips.add(friendShip);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return friendShips;
    }
}
