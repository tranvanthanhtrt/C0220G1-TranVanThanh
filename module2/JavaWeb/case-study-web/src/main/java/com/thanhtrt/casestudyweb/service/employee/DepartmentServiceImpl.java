package com.thanhtrt.casestudyweb.service.employee;

import com.thanhtrt.casestudyweb.model.employee.Department;
import com.thanhtrt.casestudyweb.repository.employee.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
