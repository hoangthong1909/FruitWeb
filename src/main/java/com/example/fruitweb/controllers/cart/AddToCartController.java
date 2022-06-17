package com.example.fruitweb.controllers.cart;
import com.example.fruitweb.entities.Order;
import com.example.fruitweb.entities.OrdersDetail;
import com.example.fruitweb.entities.Product;
import com.example.fruitweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class AddToCartController {

    @Autowired
    private IProductService productService;

    @Autowired
    private HttpSession session;


    @GetMapping("/addtocart")
    public String addToCart(@RequestParam(name = "id") Integer id, @RequestParam(name = "quantity", required = false, defaultValue = "1") Integer quantity) {
        Product product = this.productService.findById(id);
        session.setAttribute("idCu",product.getCategoryId().getId());
        if (session.getAttribute("order") == null) {
            Order order = new Order();
            OrdersDetail orderdetail = new OrdersDetail();
            orderdetail.setProduct(product);
            orderdetail.setQuantity(quantity);
            orderdetail.setPrice(product.getPrice());
            List<OrdersDetail> list = new ArrayList<>();
            list.add(orderdetail);
            order.setOrderdetails(list);
            session.setAttribute("order", order);
        } else {
            Order order = (Order) session.getAttribute("order");
            List<OrdersDetail> listOrder = order.getOrderdetails();
            boolean check = false;
            for (OrdersDetail item : listOrder) {
                if (item.getProduct().getId() == product.getId()) {
                    item.setQuantity(item.getQuantity() + quantity);
                    check = true;
                }
                if (item.getQuantity()>productService.findById(item.getProduct().getId()).getQuantity()){
                    item.setQuantity(item.getProduct().getQuantity());
                    session.setAttribute("error","Sản phẩm này đã đạt số lượng tối đa");
                }
            }
            if (check == false) {
                OrdersDetail orderdetail = new OrdersDetail();
                orderdetail.setProduct(product);
                orderdetail.setQuantity(quantity);
                orderdetail.setPrice(product.getPrice());
                listOrder.add(orderdetail);
            }
            session.setAttribute("order", order);
        }
        return "redirect:/home/cart";

    }
    @GetMapping("/cart/plus")
    public String cartPlus(@RequestParam(name = "id") Integer id){
        Order order = (Order) session.getAttribute("order");
        List<OrdersDetail> listOrder = order.getOrderdetails();
        for (OrdersDetail item : listOrder) {
            if (item.getProduct().getId() == id) {
                item.setQuantity(item.getQuantity() + 1);
            }
            if (item.getQuantity()>productService.findById(item.getProduct().getId()).getQuantity()){
                item.setQuantity(item.getProduct().getQuantity());
                session.setAttribute("error","Sản phẩm này đã đạt số lượng tối đa");
            }
        }
        return "redirect:/home/cart";
    }
    @GetMapping("/cart/minus")
    public String cartMinus(@RequestParam(name = "id") Integer id){
        Order order = (Order) session.getAttribute("order");
        List<OrdersDetail> listOrder = order.getOrderdetails();
        int check = 0;
        OrdersDetail orderdetail = new OrdersDetail();
        if (listOrder.size() > 0) {
            for (OrdersDetail item : listOrder) {
                if (item.getProduct().getId() == id) {
                    item.setQuantity(item.getQuantity() - 1);
                    if (item.getQuantity() == 0) {
                        orderdetail = item;
                        check++;
                    }
                }
            }
            if (check != 0) {
                listOrder.remove(orderdetail);
                if (listOrder.isEmpty()) {
                    session.removeAttribute("order");
                }
            }
        }
        return "redirect:/home/cart";
    }
}
