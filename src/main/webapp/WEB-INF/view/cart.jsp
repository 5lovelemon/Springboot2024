<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!-- Tomcat 10.x JSTL -->    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>購物車</title>
    <link href="images/CAKE2_logo.png" rel="icon" type="image/x-ico">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <h2 class="my-4">購物車</h2>
        <c:if test="${not empty cartItems}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>商品名稱</th>
                        <th>價格</th>
                        <th>數量</th>
                        <th>小計</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cartItems}">
                        <tr>
                            <td>${item.cakename}</td>
                            <td>${item.cakeprice}</td>
                            <td>${item.quantity}</td>
                            <td>${item.cakeprice * item.quantity}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/update-quantity" method="post" class="d-inline">
                                    <input type="hidden" name="cakeId" value="${item.cakeid}">
                                    <input type="number" name="quantity" value="${item.quantity}" min="1">
                                    <button type="submit" class="btn btn-primary btn-sm">更新</button>
                                </form>
                                <form action="${pageContext.request.contextPath}/remove-from-cart" method="post" class="d-inline">
                                    <input type="hidden" name="cakeId" value="${item.cakeid}">
                                    <button type="submit" class="btn btn-danger btn-sm">移除</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <h3 class="text-end">總價: ${totalPrice}</h3>
            <form action="${pageContext.request.contextPath}/clear-cart" method="post">
                <button type="submit" class="btn btn-warning">清空購物車</button>
            </form>
        </c:if>
        <c:if test="${empty cartItems}">
            <p>您的購物車是空的。</p>
        </c:if>
    </div>
</body>

</html>