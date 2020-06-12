package com.thanhtrt.blog.model;


import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contention;

    public Blog() {
    }

    public Blog(String name, String contention) {
        this.name = name;
        this.contention = contention;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContention() {
        return contention;
    }

    public void setContention(String contention) {
        this.contention = contention;
    }
}