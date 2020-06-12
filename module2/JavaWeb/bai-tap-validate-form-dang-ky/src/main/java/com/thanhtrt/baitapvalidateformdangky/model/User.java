package com.thanhtrt.baitapvalidateformdangky.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "không được để trống")
    @Size(min = 5,max = 45,message ="độ dài 5-45 kí tự")
    private String firstName;
    @Size(min = 5,max = 45,message ="độ dài 5-45 kí tự")
    @NotEmpty(message = "không được để trống")
    private String lastName;
    @Min(value = 18,message = "tuổi phải lớn hơn 18")
    private int age;
    @Pattern(regexp = "[a-z 1-9]+@[a-z 1-9]+[.]([a-z 1-9]+)$",message = "email dạng abc@gmail.com")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
