package com.example.fruitweb.controllers.account;
import com.example.fruitweb.entities.User;
import com.example.fruitweb.service.IUserService;
import com.example.fruitweb.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
public class RegisterController {

    @Autowired
    private HttpSession session;

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public String register( @RequestParam(name = "email", required = false) String email, @RequestParam(name = "password", required = false) String password, @RequestParam(name = "password2", required = false) String password2,@RequestParam(name = "name", required = false) String name,@RequestParam(name = "address", required = false) String address) {
        User entity = new User();
        if (password.equals(password2)) {
            if (this.userService.findByEmail(email) == null) {
                String encrypted = EncryptUtil.encrypt(password);
                entity.setPassword(encrypted);
                entity.setStatus(1);
                entity.setUsername(name);
                entity.setEmail(email);
                entity.setAddress(address);
                entity.setRole(false);
                this.userService.insert(entity);
                session.setAttribute("message", "Đăng Ký Thành Công");
                return "redirect:/login";
            } else {
                session.setAttribute("error", "Email Đã Tồn Tại");
                return "redirect:/login";
            }
        } else {
            session.setAttribute("error", "Mật khẩu không trùng với mật khẩu xác nhận");
            return "redirect:/login";
        }
    }
}
