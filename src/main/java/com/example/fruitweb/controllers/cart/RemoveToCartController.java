package com.example.fruitweb.controllers.cart;

import com.example.fruitweb.entities.Order;
import com.example.fruitweb.entities.OrdersDetail;
import com.example.fruitweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/home")
public class RemoveToCartController {

    @Autowired
    private HttpSession session;

    @GetMapping("/removecart")
    public String RemoveToCart(@RequestParam(name = "id") Integer id) {
        Order order = (Order) session.getAttribute("order");
        if (order != null) {
            List<OrdersDetail> listOrder = order.getOrderdetails();
            for (OrdersDetail item : listOrder) {
                if (item.getProduct().getId() == id) {
                    listOrder.remove(item);
                    break;
                }
            }
            if (listOrder.isEmpty()) {
                session.removeAttribute("order");
            }
            session.setAttribute("order", order);
        }
        return "redirect:/home/cart";
    }
}
