package com.thanhtrt.BlogApp.service;

import com.thanhtrt.BlogApp.model.Category;
import com.thanhtrt.BlogApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
categoryRepository.deleteById(id);
    }
}