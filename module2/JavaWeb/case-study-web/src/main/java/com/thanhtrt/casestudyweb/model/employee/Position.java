package com.thanhtrt.casestudyweb.model.employee;

import com.thanhtrt.casestudyweb.model.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employeePosition")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;



    public Position() {
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
}
