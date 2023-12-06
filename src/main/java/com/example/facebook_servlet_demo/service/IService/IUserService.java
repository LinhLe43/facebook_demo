package com.example.facebook_servlet_demo.service.IService;

import java.util.List;

public interface IUserService<C> {
    C checkLogin(String name, String password);
    void add(C c);
    void edit(int id, C c);
    void delete(int id);
    List<C> findAll();
}
