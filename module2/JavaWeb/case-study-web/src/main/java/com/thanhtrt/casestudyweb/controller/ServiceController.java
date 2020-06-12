package com.thanhtrt.casestudyweb.controller;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.service.Service;
import com.thanhtrt.casestudyweb.model.service.ServiceType;
import com.thanhtrt.casestudyweb.model.service.TypeOfRent;
import com.thanhtrt.casestudyweb.model.validator.ServiceValidator;
import com.thanhtrt.casestudyweb.service.RentType.RentypeService;
import com.thanhtrt.casestudyweb.service.ServiceFurama.ServiceFuramaService;
import com.thanhtrt.casestudyweb.service.ServiceFurama.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    ServiceTypeService serviceTypeService;
    @Autowired
    RentypeService  rentypeService;
    @Autowired
    ServiceFuramaService serviceFuramaService;

    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }
    @ModelAttribute("rentTypes")
    public List<TypeOfRent> rentTypes() {
        return rentypeService.findAll();
    }
    @GetMapping("/create-service")
    public ModelAndView showCreateServiceForm() {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }
    @PostMapping("/create-service")
    public ModelAndView saveService(@Valid  @ModelAttribute("service") Service service, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView(("/service/create"));
        new ServiceValidator().validate(service,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return modelAndView;
        }
        serviceFuramaService.save(service);
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
}
