package com.example.facebook_servlet_demo.service.IService;

import java.util.List;

public interface ICommentService<C> {
    void add(C c);
    void edit(int id, C c);
    void delete(int id);
    List<C> findAll();
    C getById(int id);
}
