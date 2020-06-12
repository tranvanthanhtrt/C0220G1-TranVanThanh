package com.thanhtrt.module2examination.controller;

import com.thanhtrt.module2examination.model.*;
import com.thanhtrt.module2examination.service.LoaiHangService;
import com.thanhtrt.module2examination.service.NhanVienService;
import com.thanhtrt.module2examination.service.NhomNhanVienService;
import com.thanhtrt.module2examination.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    private NhomNhanVienService nhomNhanVienService;

    @ModelAttribute("listNhomNhanVien")
    public List<NhomNhanVien> nhomNhanVienList() {
        return nhomNhanVienService.findAll();
    }

    @GetMapping("/create-nhanvien")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanVien", new NhanVien());
        return modelAndView;
    }

    @PostMapping("/create-nhanvien")
    public String saveProduct(@Validated @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        new NhanVienValidator().validate(nhanVien, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("nhanVien", nhanVien);
            return "/nhanvien/create";

        }
        nhanVienService.save(nhanVien);
        redirect.addFlashAttribute("message", "Tao nhan vien thanh cong");
        return "redirect:list-nhanvien";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }

    @GetMapping("/list-nhanvien")
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, @PageableDefault(size = 4) Pageable pageable) {
        Page<NhanVien> nhanViens;
        ModelAndView modelAndView = new ModelAndView("/nhanvien/list");

        if (s.isPresent()) {
            modelAndView.addObject("s", s.get());
            nhanViens = nhanVienService.findAllByCmndContaining(s.get(), pageable);
        } else {
            nhanViens = nhanVienService.findAll(pageable);
        }
        modelAndView.addObject("nhaviens", nhanViens);
        return modelAndView;
    }

    @GetMapping("/edit-nhanvien/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<NhanVien> nhanVien = nhanVienService.findById(id);
        if (nhanVien.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
            modelAndView.addObject("nhanvien", nhanVien);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-nhanvien")
    public ModelAndView updateNhanVien(@Validated @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");

        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("nhanvien", nhanVien);
            return modelAndView;

        }
        nhanVienService.save(nhanVien);
//        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Cap nhat nhan vien thanh cong");
        return modelAndView;
    }

    @GetMapping("/delete-nhanvien/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        nhanVienService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xoa Nhan Vien Thanh Cong");
        return "redirect:/list-nhanvien";
    }
}
