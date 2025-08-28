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

<form action="login" method="post">
    <h2>Tạo tài khoản mới</h2>
    
    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control">
            </div>
        </label>
    </section>

    <br>
    <button type="submit">Đăng ký</button>
</form>

<form action="login" method="post">
    <h2>Đăng nhập</h2>

    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>

    <input type="text" placeholder="Tài khoản" name="username"><br>
    <input type="password" placeholder="Mật khẩu" name="password"><br>
    <label><input type="checkbox" name="remember"> Remember me</label><br>

    <button type="submit">Đăng nhập</button>
</form>


</body>
</html>
