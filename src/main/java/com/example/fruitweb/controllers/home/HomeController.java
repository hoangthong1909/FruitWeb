package com.example.fruitweb.controllers.home;

import com.example.fruitweb.service.ICategoryService;
import com.example.fruitweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
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
    public String index(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page) {
        model.addAttribute("listCate",categoryService.findAll());
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        model.addAttribute("show",productService.findAllinPage(pageable));
        request.setAttribute("view", "/views/home/home.jsp");
        return "home/layout";
    }
//    @GetMapping("/showNro")
//    public String show(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Optional<Integer> page,@RequestParam(name = "id") Integer id) {
//        Pageable pageable = PageRequest.of(page.orElse(0), 5);
//        model.addAttribute("listItems", itemsDao.findItemsByCate(id,pageable));
//        request.setAttribute("view", "/views/home/items.jsp");
//        return "home/layout";
//    }
}
