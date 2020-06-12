package com.thanhtrt.BlogApp.service;

import com.thanhtrt.BlogApp.model.Category;
import com.thanhtrt.BlogApp.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);

}
