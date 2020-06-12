package com.thanhtrt.BlogApp.service;


import com.thanhtrt.BlogApp.model.Blog;
import com.thanhtrt.BlogApp.model.Category;
import com.thanhtrt.BlogApp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAllByOrderByWriteOfDayDesc(pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByCategory(Optional<Category> category, Pageable pageable) {
        return blogRepository.findAllByCategoryOrderByWriteOfDay(category,pageable);
    }


}
