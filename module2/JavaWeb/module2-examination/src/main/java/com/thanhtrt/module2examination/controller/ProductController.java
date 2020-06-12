package com.thanhtrt.module2examination.controller;

import com.thanhtrt.module2examination.model.Customer;
import com.thanhtrt.module2examination.model.LoaiHang;
import com.thanhtrt.module2examination.model.Product;
import com.thanhtrt.module2examination.model.Province;
import com.thanhtrt.module2examination.service.LoaiHangService;
import com.thanhtrt.module2examination.service.ProductService;
import com.thanhtrt.module2examination.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    private LoaiHangService loaiHangService;

    @ModelAttribute("listLoaiHang")
    public List<LoaiHang> loaiHangList() {
        return loaiHangService.findAll();
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public String saveProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirect, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("product",product);
            return "/product/create";

        }
        Date date = new Date(System.currentTimeMillis());
        product.setNgaytao(date);
        productService.save(product);
        redirect.addFlashAttribute("message", "Product has create successfully");
        return "redirect:list-product";
    }

    @GetMapping("/list-product")
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, @PageableDefault(size = 4) Pageable pageable) {
        Page<Product> products;
        ModelAndView modelAndView = new ModelAndView("/product/list");

        if (s.isPresent()) {
            modelAndView.addObject("s", s.get());
            products = productService.findAllByNameContaining(s.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateCustomer(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/product/edit");

        if (bindingResult.hasFieldErrors()) {
modelAndView.addObject("product",product) ;
return modelAndView;

        }
        productService.save(product);
//        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "product updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "product has removed successfully");
        return "redirect:/list-product";
    }
}
