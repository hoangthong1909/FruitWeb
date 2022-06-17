package com.example.fruitweb.controllers.account;

import com.example.fruitweb.entities.User;
import com.example.fruitweb.service.IUserService;
import com.example.fruitweb.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController  {
    @Autowired
    private HttpSession session;

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String loginUI() {
        return "login";
    }

    @PostMapping("/loginAccount")
    public String login(@RequestParam(name = "email", required = false) String email, @RequestParam(name = "password", required = false) String password) {
        User user = this.userService.findByEmail(email);
        if (user == null) {
            session.setAttribute("error", "Tên Đăng Nhập Không Tồn Tại");
            return "redirect:/login";
        } else {
            boolean check = EncryptUtil.check(password, user.getPassword());
            if (check == true) {
                // Đăng nhập thành công
                if (user.getRole() == true) {
                    session.setAttribute("user", user);
                    return "redirect:/admin/user/index";
                } else {
                    Object ruri = session.getAttribute("secureUri");
                    if (ruri != null) {
                        session.setAttribute("user", user);
                        session.removeAttribute("secureUri");
                        return "redirect:" +ruri;
                    }else {
                    session.setAttribute("user", user);
                    return "redirect:/home/index";
                    }
                }
            } else {
                // Đăng nhập thất bại
                session.setAttribute("error", "Mật Khẩu không chính xác ");
                return "redirect:/login";
            }
        }
    }

    @GetMapping("logout")
    public String logout() {
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
