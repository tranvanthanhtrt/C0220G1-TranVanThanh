package com.thanhtrt.BlogApp.controller;


import com.thanhtrt.BlogApp.model.Blog;
import com.thanhtrt.BlogApp.model.Category;
import com.thanhtrt.BlogApp.service.BlogService;
import com.thanhtrt.BlogApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.jws.WebParam;
import java.util.List;
import java.util.Optional;

@RestController
public class RestFullController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/rest-blogs", method = RequestMethod.GET)
    public ResponseEntity<Page<Blog>> getAllListBlog(Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

//    @RequestMapping(value = "/rest-blog/{id}", method = RequestMethod.GET, produces = { "application/xml", "text/xml" })
    @RequestMapping(value = "/rest-blog/{id}", method = RequestMethod.GET)

    public ResponseEntity<Blog> getBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest-saveblog", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating blog " + blog.getName());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/rest-blog/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/rest-updateblog/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") long id, @RequestBody Blog blog){
        System.out.println("Updating blog " + blog.getName());
        Optional<Blog> curblog=blogService.findById(id);
        if (!curblog.isPresent()) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        curblog.get().setName(blog.getName());
        curblog.get().setCategory(blog.getCategory());
        curblog.get().setContention(blog.getContention());
        curblog.get().setWriteOfDay(blog.getWriteOfDay());
        blogService.save(curblog.get());
return new ResponseEntity<Blog>(curblog.get(),HttpStatus.OK);

    }
    @RequestMapping(value = "/rest-blogs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Blog with id " + id);

        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
}

