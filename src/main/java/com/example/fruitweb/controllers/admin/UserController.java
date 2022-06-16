package com.example.fruitweb.controllers.admin;

import com.example.fruitweb.service.IUserService;
import com.example.fruitweb.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/index")
    public String index() {
        this.userService.findAll();
        return "ngu";
    }
}