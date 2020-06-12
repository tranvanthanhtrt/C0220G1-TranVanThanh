package com.thanhtrt.BlogApp.repository;


import com.thanhtrt.BlogApp.model.Blog;
import com.thanhtrt.BlogApp.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {


    Page<Blog> findAllByCategoryOrderByWriteOfDay(Optional<Category> category, Pageable pageable);
    Page<Blog> findAllByOrderByWriteOfDayDesc(Pageable pageable);


}
