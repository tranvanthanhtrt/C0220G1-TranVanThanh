package com.thanhtrt.blog.repository;


import com.thanhtrt.blog.model.Blog;

import java.util.List;

public interface BlogRepository{
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog model);

    void remove(Long id);

}
