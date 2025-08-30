<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>

    <%@ include file="topbar.jsp" %>

    <h2>Đăng nhập</h2>
    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    
    <h2>Note:</h2>
    <ul>
        <li>Admin: trungAdmin - 123 → http://localhost:8080/vidu1/home1.jsp</li>
        <li>Manager: trungManager - 123 → http://localhost:8080/vidu1/home2.jsp</li>
        <li>User: trungUser - 123 → http://localhost:8080/vidu1/home3.jsp</li>
    </ul>

    <form action="login" method="post">

        <!-- username -->
        <section>
            <label>Tài khoản</label>
            <input type="text" name="username" placeholder="Tài khoản">
        </section>

        <!-- password -->
        <section>
            <label>Mật khẩu</label>
            <input type="password" name="password" placeholder="Mật khẩu">
        </section>

        <!-- remember -->
        <section>
            <input type="checkbox" name="remember"> Ghi nhớ đăng nhập
        </section>

        <br>
        <button type="submit">Đăng nhập</button>
        <a href="register.jsp">Đăng ký tài khoản mới</a>
    </form>

</body>
</html>
