<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title> <!-- Sửa title từ "Đăng ký tài khoản" thành "Đăng nhập" để đúng -->
</head>
<body>

    <form action="login" method="post">
        <h2>Đăng nhập</h2> <!-- Sửa h2 từ "Tạo tài khoản mới" thành "Đăng nhập" -->

        <c:if test="${alert != null}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>

        <section>
            <label class="input login-input">
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-user"></i>
                    </span>
                    <input type="text" placeholder="Tài khoản" name="username" class="form-control">
                </div>
            </label>
        </section>

        <section>
            <label class="input login-input">
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-lock"></i> <!-- Thêm icon lock cho đẹp -->
                    </span>
                    <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
                </div>
            </label>
        </section>

        <section>
            <label>
                <input type="checkbox" name="remember"> Ghi nhớ đăng nhập <!-- Thêm checkbox remember -->
            </label>
        </section>

        <br>
        <button type="submit">Đăng nhập</button>
    </form>

</body>
</html>