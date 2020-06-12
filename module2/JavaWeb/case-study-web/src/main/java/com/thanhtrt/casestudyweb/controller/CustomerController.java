package com.thanhtrt.casestudyweb.controller;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.customer.CustomerType;
import com.thanhtrt.casestudyweb.model.validator.CustomerValidator;
import com.thanhtrt.casestudyweb.service.contract.ContractService;
import com.thanhtrt.casestudyweb.service.customer.CustomerService;
import com.thanhtrt.casestudyweb.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerTypeService customerTypeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ContractService contractService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("static", "create");
        return modelAndView;
    }

    @PostMapping("/create-customer/{st}")
    public ModelAndView saveCustomer(@PathVariable("st") String st, @Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView(("/customer/create"));
        if (st.equals("create")) {
            modelAndView.addObject("static", "create");
        } else {
            modelAndView.addObject("static", "edit");
        }
        new CustomerValidator().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        customerService.save(customer);
        modelAndView.addObject("customer", customer);
        if (st.equals("create")) {
            modelAndView.addObject("message", "New customer created successfully");
        } else modelAndView.addObject("message", "Update successfully");
        return modelAndView;
    }

    @GetMapping("/list-customer")
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, @PageableDefault(size = 4) Pageable pageable) {
        Page<Customer> customers;
        ModelAndView modelAndView = new ModelAndView("/customer/list");

        if (s.isPresent()) {
            modelAndView.addObject("s", s.get());
            customers = customerService.findAllByNameContaining(s.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/list-customer-booking")
    public ModelAndView listCustomerBooking(@RequestParam("s") Optional<String> s, @PageableDefault(size = 4) Pageable pageable) {
        Page<Contract> contracts;
        ModelAndView modelAndView = new ModelAndView("/customer/listBooking");

        if (s.isPresent()) {
            modelAndView.addObject("s", s.get());
            contracts = contractService.findAllByNameCustomer(s.get(), pageable);
        } else {
            contracts = contractService.findAll(pageable);
        }
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping("/view-customer/{id}")
    public ModelAndView view(@PathVariable String id) {
        Optional<Customer> customer = customerService.finById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("/customer/view");
            modelAndView.addObject("customer", customer);

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}/{name}")
    public String delete(@PathVariable String id,@PathVariable String name, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Customer has removed successfully");
        return "redirect:/list-customer";
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView edit(@PathVariable String id) {
        Optional<Customer> customer = customerService.finById(id);
        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("static", "edit");

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }
}
