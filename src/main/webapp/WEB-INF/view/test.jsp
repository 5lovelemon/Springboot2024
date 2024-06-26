<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Tomcat 10.x JSTL -->    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登录状态示例</title>
</head>
<body>
    <div>
        <c:if test="${not empty sessionScope.loggedInUser}">
            <!-- 显示登录状态信息，例如用户名 -->
            <p>Welcome, ${sessionScope.loggedInUser.username}!</p>
            <!-- 显示登出按钮 -->
            <form action="${pageContext.request.contextPath}/logout" method="get">
                <button type="submit">Logout</button>
            </form>
        </c:if>
        <c:if test="${empty sessionScope.loggedInUser}">
            <!-- 显示登录按钮或登录表单 -->
            <form action="${pageContext.request.contextPath}/cname" method="post">
                <!-- 输入用户名和密码的表单 -->
                <input type="text" name="email" placeholder="Email">
                <input type="password" name="password" placeholder="Password">
                <button type="submit">Login</button>
            </form>
        </c:if>
    </div>
</body>
</html>
