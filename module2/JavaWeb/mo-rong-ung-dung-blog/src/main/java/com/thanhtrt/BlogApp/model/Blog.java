package com.thanhtrt.BlogApp.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contention;
    private Date writeOfDay;
    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;
    public Blog() {
    }

    public Blog(String name, String contention,Date writeOfDay,Category category) {
        this.name = name;
        this.contention = contention;
        this.writeOfDay=writeOfDay;
        this.category=category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getWriteOfDay() {
        return writeOfDay;
    }

    public void setWriteOfDay(Date writeOfDay) {
        this.writeOfDay = writeOfDay;
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