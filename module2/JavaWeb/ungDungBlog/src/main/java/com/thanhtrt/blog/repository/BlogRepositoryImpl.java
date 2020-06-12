package com.thanhtrt.blog.repository;

import com.thanhtrt.blog.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Blog>findAll() {
        TypedQuery<Blog> query=entityManager.createQuery("select  c from Blog c ",Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query=entityManager.createQuery("select c from Blog c where c.id=:id",Blog.class);
        query.setParameter("id",id);
        try {
            return  query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void save(Blog model) {
        if(model.getId()!=null){
            entityManager.merge(model);
        }else
        {
            entityManager.persist(model);
        }

    }

    @Override
    public void remove(Long id) {
Blog blog= findById(id);
if(blog!=null){
    entityManager.remove(blog);
}
    }
}
