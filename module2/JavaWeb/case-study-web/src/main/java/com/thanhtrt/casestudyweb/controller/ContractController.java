package com.thanhtrt.casestudyweb.controller;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.customer.CustomerType;
import com.thanhtrt.casestudyweb.model.employee.Employee;
import com.thanhtrt.casestudyweb.model.service.Service;
import com.thanhtrt.casestudyweb.model.validator.ContractValidator;
import com.thanhtrt.casestudyweb.model.validator.CustomerValidator;
import com.thanhtrt.casestudyweb.service.ServiceFurama.ServiceFuramaService;
import com.thanhtrt.casestudyweb.service.contract.ContractService;
import com.thanhtrt.casestudyweb.service.customer.CustomerService;
import com.thanhtrt.casestudyweb.service.customer.CustomerTypeService;
import com.thanhtrt.casestudyweb.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ContractController {
    @Autowired
    CustomerService customerService;

    @ModelAttribute("customerList")
    public Page<Customer> customerList(Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @Autowired
    ServiceFuramaService serviceFuramaService;

    @ModelAttribute("servicesList")
    public List<Service> serviceList() {
        return serviceFuramaService.findAll();
    }

    @Autowired
    EmployeeService employeeService;

    @ModelAttribute("employeesList")
    public List<Employee> employeeList() {
        return employeeService.findAll();
    }

    @Autowired
    ContractService contractService;

    @GetMapping("/create-contract")
    public ModelAndView showCreateContractForm() {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contract", new Contract());
        return modelAndView;
    }

    @PostMapping("/create-contract")
    public ModelAndView saveContract(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(("/contract/create"));

//        contract.setTotal((long) contract.getService().getRentalCost()*(contract.getEndDay().getTime()-contract.getStartDay().getTime())/(60*60*24*1000));
        new ContractValidator().validate(contract, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        contractService.save(contract);
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("message", "New contract created successfully");
        return modelAndView;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }
}
