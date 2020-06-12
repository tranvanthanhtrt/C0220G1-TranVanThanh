package com.thanhtrt.casestudyweb.controller;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.employee.Department;
import com.thanhtrt.casestudyweb.model.employee.Employee;
import com.thanhtrt.casestudyweb.model.employee.Level;
import com.thanhtrt.casestudyweb.model.employee.Position;
import com.thanhtrt.casestudyweb.model.service.Service;
import com.thanhtrt.casestudyweb.model.service.ServiceType;
import com.thanhtrt.casestudyweb.repository.employee.EmployeeRepository;
import com.thanhtrt.casestudyweb.service.ServiceFurama.ServiceFuramaService;
import com.thanhtrt.casestudyweb.service.ServiceFurama.ServiceTypeService;
import com.thanhtrt.casestudyweb.service.employee.DepartmentService;
import com.thanhtrt.casestudyweb.service.employee.LevelService;
import com.thanhtrt.casestudyweb.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    LevelService levelService;
    @Autowired
    PositionService positionService;
    @ModelAttribute("employeeLevels")
    public List<Level> levels() {
        return levelService.findAll();
    }
    @ModelAttribute("employeePosition")
    public List<Position> posotion() {
        return positionService.findAll();
    }
    @ModelAttribute("employeeDepartments")
    public List<Department> departments() {
        return departmentService.findAll();
    }
    @GetMapping("/create-employee")
    public ModelAndView showCreateEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    @PostMapping("/create-employee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        ModelAndView modelAndView = new ModelAndView(("/employee/create"));
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }
}
