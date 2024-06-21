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
    <title>訂單列表</title>
    <link href="images/CAKE2_logo.png" rel="icon" type="image/x-ico">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <h2 class="my-4">訂單列表</h2>
        <c:if test="${not empty orders}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>訂單編號</th>
                        <th>用戶ID</th>
                        <th>蛋糕ID</th>
                        <th>數量</th>
                        <th>訂單狀態</th>
                        <th>總價</th>
                        <th>創建時間</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.userId}</td>
                            <td>${order.cakeId}</td>
                            <td>${order.quantity}</td>
                            <td>${order.orderStatus}</td>
                            <td>${order.totalPrice}</td>
                            <td>${order.createdAt}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty orders}">
            <p>目前沒有訂單。</p>
        </c:if>
    </div>
</body>

</html>