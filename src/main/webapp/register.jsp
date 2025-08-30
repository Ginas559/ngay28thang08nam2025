<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>

    <form action="register" method="post">
        <h2>Tạo tài khoản mới</h2>
        <c:if test="${alert != null}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>

        <!-- username -->
        <section>
            <label>Username</label>
            <input type="text" name="username" placeholder="Tài khoản">
        </section>

        <!-- fullname -->
        <section>
            <label>Họ và tên</label>
            <input type="text" name="fullname" placeholder="Họ và tên">
        </section>

        <!-- email -->
        <section>
            <label>Email</label>
            <input type="email" name="email" placeholder="Email">
        </section>

        <!-- phone -->
        <section>
            <label>Số điện thoại</label>
            <input type="text" name="phone" placeholder="Số điện thoại">
        </section>

        <!-- password -->
        <section>
            <label>Mật khẩu</label>
            <input type="password" name="password" placeholder="Mật khẩu">
        </section>

        <br>
        <button type="submit">Đăng ký</button>
    </form>

</body>
</html>
