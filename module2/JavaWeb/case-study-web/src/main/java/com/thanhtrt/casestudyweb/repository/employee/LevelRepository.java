package com.thanhtrt.casestudyweb.repository.employee;

import com.thanhtrt.casestudyweb.model.employee.Employee;
import com.thanhtrt.casestudyweb.model.employee.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level,Long> {
}
