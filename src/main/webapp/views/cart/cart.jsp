<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="row">
            <c:if test="${!empty sessionScope.error}">
                <div class="alert alert-danger">
                        ${sessionScope.error}
                </div>
                <c:remove var="error" scope="session"/>
            </c:if>
            <div class="table-responsive cart_info col-sm-9">
                <table class="table table-condensed">
                    <thead>
                    <tr class="cart_menu">
                        <td class="description"><b>STT</b></td>
                        <td class="image">Product</td>
                        <td class="description">Name</td>
                        <td class="price">Price</td>
                        <td class="quantity">Quantity</td>
                        <td class="total">Total</td>
                        <td></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty sessionScope.order.orderdetails}">
                        <td><p style="color: red;font-size: 20px">Bạn chưa có sản phẩm nào trong giỏ hàng</p></td>
                    </c:if>
                    <c:forEach items="${sessionScope.order.orderdetails}" var="cart" varStatus="status">
                        <tr>
                            <td class="cart_description">
                                <b> #${status.count}</b>
                            </td>
                            <td class="cart_product">
                                <img height="60px" src="${cart.product.img}" alt="">
                            </td>
                            <td class="cart_description">
                                    ${cart.product.name}
                            </td>
                            <td class="cart_price">
                                <fmt:formatNumber value="${cart.product.price}" pattern="#,###"/>
                            </td>
                            <td class="cart_quantity">
                                <div class="cart_quantity_button">
                                    <a class="cart_quantity_up" href="/home/cart/plus?id=${cart.product.id}"> + </a>
                                    <input class="cart_quantity_input" type="text" name="quantity"
                                           value="${cart.quantity}" autocomplete="off" size="2">
                                    <a class="cart_quantity_down" href="/home/cart/minus?id=${cart.product.id}"> - </a>
                                </div>
                            </td>
                            <td class="cart_total">
                                <span style="color: red"><fmt:formatNumber value="${cart.product.price*cart.quantity}"
                                                                           pattern="#,###"/> VND</span>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete" href="/home/removecart?id=${cart.product.id}"><i
                                        class="fa fa-times"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-3">
                <p>Bạn có <span style="color: red;font-size: 15px">${quantityVP}</span> sản phẩm trong giỏ
                    hàng</p>
                <hr>
                <p>Tổng số lượng sản phẩm : <span style="color: red;font-size: 15px">${quantityVP}</span> sản phẩm </p>
                <hr>
                <b>Thành Tiền :&ensp; &ensp; &ensp;&ensp;&ensp;<span
                        style="color: red; font-size: 20px"><fmt:formatNumber value="${total}"
                                                                              pattern="#,###"/> VND</span></b>
                <hr>
                <p>Thanh Toán Khi Nhận Hàng</p>
                <hr>
                <c:if test="${!empty sessionScope.order}">
                    &ensp;&ensp;<div class="col-12 mb-5 mb-md-0">
                    <form action="/home/addtoorder" method="get">
                        <h2 class="h3 mb-3 text-black">Nhập Thông Tin Nhận Hàng</h2>
                        <div class="p-3 p-lg-5 border">
                            <div class="form-group row">
                                <div class="col-md-6">
                                    <label class="form-label fw-bold">Name</label>
                                    <input type="text" class="form-control" name="name">
                                </div>
                                <div class="col-md-6">
                                    <label class="text-black">Phone </label>
                                    <input type="text" class="form-control" name="phone" >
                                </div>
                            </div>
                        </div>
                        <div class="form-group row mb-5">
                            <div class="col-md-12">
                                <label class="form-label fw-bold">Address</label>
                                <input type="text" class="form-control" name="address">
                            </div>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success" >Đặt Hàng</button>
                        </div>
                    </form>
                    </div>
                </c:if>
                <hr>
                &ensp;&ensp; <a class="btn btn-warning" href="/home/index">Tiếp Tục Mua Hàng</a>
            </div>

        </div>

    </div>

    </div>
</section>
<!--/#cart_items-->
<br>
<br>
