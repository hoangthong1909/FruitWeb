<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="left-sidebar">
                    <div class="brands_products"><!--brands_products-->
                        <h2>Danh Mục</h2>
                        <div class="brands-name">
                                <c:forEach items="${listCate}" var="cate">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/home/show?id=${cate.id}">${cate.name}</a></li>
                                <hr>
                            </ul>
                                </c:forEach>
                        </div>
                    </div><!--/brands_products-->
                </div>
            </div>

            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Danh Mục Sản Phẩm</h2>
                <c:forEach items="${show.content}" var="pro">
                    <div class="col-sm-4 contentPage">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <h2>${pro.name}</h2>
                                    <hr>
                                    <img src="${pro.img}" alt="" />
                                    <h3 style="color: red"><fmt:formatNumber value="${pro.price}" pattern="#,###"/> VND</h3>
                                    <a href="/home/addtocart?id=${pro.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm giỏ hàng</a>
                                    <a href="/home/detail?id=${pro.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Chi Tiết</a>
                                </div>
<%--                                <div class="product-overlay">--%>
<%--                                    <div class="overlay-content">--%>
<%--                                        <h3 style="color: red"><fmt:formatNumber value="${pro.price}" pattern="#,###"/> VND</h3>--%>
<%--                                        <p>${pro.name}</p>--%>
<%--                                        <a href="/home/addtocart?id=${pro.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm giỏ hàng</a>--%>
<%--                                        <a href="/home/detail?id=${pro.id}" class="btn btn-default add-to-cart">Chi Tiết</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                            </div>

                        </div>
                    </div>
                </c:forEach>

                </div><!--features_items-->
                <div id="pagination"></div>

            </div>
        </div>
    </div>
</section>
