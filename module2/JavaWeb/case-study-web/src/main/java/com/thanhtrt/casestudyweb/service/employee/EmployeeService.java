package com.thanhtrt.casestudyweb.service.employee;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> finById(Long id);
    void save(Employee employee);
    void remove(Long id);
}
