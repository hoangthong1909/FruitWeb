package com.example.fruitweb.controllers.cart;

import com.example.fruitweb.entities.Order;
import com.example.fruitweb.entities.OrdersDetail;
import com.example.fruitweb.entities.Product;
import com.example.fruitweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
@Controller
@RequestMapping("/home")
public class CartController {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IProductService productService;

    @GetMapping("/cart")
    public String getCart(Model model){
        BigDecimal total = new BigDecimal(0);
        Boolean check=false;
        int quantity = 0;
        int quantityCart=0;
        Order order = (Order) session.getAttribute("order");
        if (order == null) {
            total = new BigDecimal(0);
            quantity = 0;
            check=false;
        } else {
            check=true;
            List<OrdersDetail> listOrder = order.getOrderdetails();
            List<Product> itemsList =productService.findAll();
            for (Product i: itemsList) {
                for (OrdersDetail item : listOrder) {
                    if (i.getId()==item.getProduct().getId()){
                        item.setProduct(i);
                        BigDecimal q = BigDecimal.valueOf(item.getQuantity());
                        total = total.add(i.getPrice().multiply(q));
                        quantity += item.getQuantity();
                    }
                }
            }
            quantityCart+= listOrder.size();
        }
        session.setAttribute("total",total);
        model.addAttribute("quantityVP",quantity);
        model.addAttribute("check",check);
        model.addAttribute("quantityCart",quantityCart);
        request.setAttribute("view","/views/cart/cart.jsp");
        return "home/layout";
    }
}
