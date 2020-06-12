package com.thanhtrt.casestudyweb.repository.employee;

import com.thanhtrt.casestudyweb.model.employee.Employee;
import com.thanhtrt.casestudyweb.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository  extends JpaRepository<Position,Long> {
}
