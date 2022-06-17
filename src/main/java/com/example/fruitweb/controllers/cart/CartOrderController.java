package com.example.fruitweb.controllers.cart;

import com.example.fruitweb.entities.Order;
import com.example.fruitweb.entities.OrdersDetail;
import com.example.fruitweb.entities.Product;
import com.example.fruitweb.entities.User;
import com.example.fruitweb.service.IOrderDetailService;
import com.example.fruitweb.service.IOrderService;
import com.example.fruitweb.service.IProductService;
import com.example.fruitweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class CartOrderController {
    @Autowired
    private HttpSession session;
    @Autowired
    private Order order;

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderDetailService orderDetailsService;

    @GetMapping("addtoorder")
    public String addOrder(@RequestParam(name = "name") String name,@RequestParam(name = "address") String address,@RequestParam(name = "phone") String phone) {
        Order orderSession = (Order) session.getAttribute("order");
        if (orderSession != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                List<OrdersDetail> listOrder = orderSession.getOrderdetails();
                List<Product> itemsList = productService.findAll();
                order.setUserOrder(user);
                order.setAddress(address);
                order.setPhone(phone);
                order.setOrderdetails(listOrder);
                order.setCreateDate(new Date());
                order.setStatus(0);
                BigDecimal total= (BigDecimal) session.getAttribute("total");
                order.setTotal(total);
                    try {
                        this.orderService.insert(order);
                        for (OrdersDetail item : listOrder) {
                            OrdersDetail orderDetail = new OrdersDetail();
                            orderDetail.setOrder(order);
                            orderDetail.setQuantity(item.getQuantity());
                            orderDetail.setPrice(item.getPrice());
                            orderDetail.setProduct(item.getProduct());
                            this.orderDetailsService.insert(orderDetail);
                            for (Product i : itemsList) {
                                if (item.getProduct().getId() == i.getId()) {
                                    i.setQuantity(i.getQuantity() - item.getQuantity());
                                    this.productService.update(i);
                                    System.out.println(i.getQuantity());
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    session.removeAttribute("order");
                    return "redirect:/home/history/buyitems";
            } else {
                return "redirect:/login";
            }
        } else {
            return "redirect:/home/cart";
        }
    }
}
