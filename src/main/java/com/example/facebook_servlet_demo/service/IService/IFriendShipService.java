package com.example.facebook_servlet_demo.service.IService;

import java.util.List;

public interface IFriendShipService<C> {
    void add (C c);

    List<C> findAll();
}
