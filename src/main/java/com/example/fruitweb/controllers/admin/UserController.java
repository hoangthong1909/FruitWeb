package com.example.fruitweb.controllers.admin;

import com.example.fruitweb.entities.User;
import com.example.fruitweb.service.IUserService;
import com.example.fruitweb.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    private IUserService userService;

    @Autowired
    HttpSession session;

    @GetMapping("/index")
    public String index(@ModelAttribute("user") User user, Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        model.addAttribute("list", userService.findAllinPage(pageable));
        request.setAttribute("view","/views/admin/user.jsp");
        return "layout";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user,@RequestParam(name = "password") String password) {
        try {
            String encrypted = EncryptUtil.encrypt(password);
            user.setStatus(1);
            user.setPassword(encrypted);
            this.userService.insert(user);
            session.setAttribute("message", "Thêm Mới Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Mới Thất Bại");
        }
        return "redirect:/admin/user/index";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Integer id, Model model, @ModelAttribute("user") User user, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        model.addAttribute("user", userService.findById(id));
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        request.setAttribute("list", userService.findAllinPage(pageable));
        request.setAttribute("view","/views/admin/user.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam(name = "id") Integer id) {
        try {
            User u=userService.findById(id);
            user.setPassword(u.getPassword());
            user.setStatus(u.getStatus());
            this.userService.update(user);
            session.setAttribute("message", "Cập Nhật Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập Nhật Thất Bại");
        }
        return "redirect:/admin/user/index";
    }

    @PostMapping("/delete")
    public String delete( @RequestParam(name = "id") Integer id) {
        try {
            User user=userService.findById(id);
            user.setStatus(0);
            this.userService.update(user);
            session.setAttribute("message", "Xóa Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
        }
        return "redirect:/admin/user/index";
    }
}


