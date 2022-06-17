package com.example.fruitweb.controllers.admin;

import com.example.fruitweb.entities.Product;
import com.example.fruitweb.entities.User;
import com.example.fruitweb.service.ICategoryService;
import com.example.fruitweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("admin/product")
public class ProductController {
    @Autowired
    ServletContext app;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @GetMapping("/index")
    public String index(@ModelAttribute("product") Product product, Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        model.addAttribute("list", productService.findAllinPage(pageable));
        model.addAttribute("listCate",categoryService.findAll());
        request.setAttribute("view","/views/admin/product.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("product") Product product,@RequestParam("attach") MultipartFile attach) {
        try {
            product.setStatus(1);
            if (!attach.isEmpty()) {
                String filename = attach.getOriginalFilename();
                File file = new File(app.getRealPath("/images/products/" + filename));
                product.setImg("/images/products/" + filename);
                try {
                    attach.transferTo(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            this.productService.insert(product);
            session.setAttribute("message", "Thêm Mới Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }
        return "redirect:/admin/product/index";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Integer id, Model model, @ModelAttribute("product") Product product, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        model.addAttribute("pro", productService.findById(id));
        model.addAttribute("listCate",categoryService.findAll());
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        request.setAttribute("list", productService.findAllinPage(pageable));
        request.setAttribute("view","/views/admin/product.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, @RequestParam(name = "id") Integer id,@RequestParam("attach") MultipartFile attach) {
        try {
            Product p = productService.findById(id);
            product.setStatus(p.getStatus());
            if (!attach.isEmpty()) {
                String filename = attach.getOriginalFilename();
                File file = new File(app.getRealPath("/images/products/" + filename));
                product.setImg("/images/products/" + filename);
                try {
                    attach.transferTo(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                product.setImg(p.getImg());
            }
            this.productService.update(product);
            session.setAttribute("message", "Cập Nhật Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
        }
        return "redirect:/admin/product/index";
    }

    @PostMapping("/delete")
    public String delete( @RequestParam(name = "id") Integer id) {
        try {
            Product product=productService.findById(id);
            product.setStatus(0);
            this.productService.update(product);
            session.setAttribute("message", "Xoa Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xoa Thất Bại");
        }
        return "redirect:/admin/product/index";
    }
}

