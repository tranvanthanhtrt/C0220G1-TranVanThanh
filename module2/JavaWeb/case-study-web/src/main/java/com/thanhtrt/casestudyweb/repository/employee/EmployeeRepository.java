package com.thanhtrt.casestudyweb.repository.employee;

import com.thanhtrt.casestudyweb.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
