<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông tin tài khoản</title>
</head>
<body>

    <h2>Infor:</h2>

    <c:choose>
        <c:when test="${sessionScope.account == null}">
            <p>Bạn chưa đăng nhập. Vui lòng 
                <a href="${pageContext.request.contextPath}/login.jsp">đăng nhập</a>.
            </p>
        </c:when>
        <c:otherwise>
            <p><b>ID:</b> ${sessionScope.account.id}</p>
            <p><b>Email:</b> ${sessionScope.account.email}</p>
            <p><b>Tên đăng nhập:</b> ${sessionScope.account.userName}</p>
            <p><b>Họ tên:</b> ${sessionScope.account.fullName}</p>
            <p><b>Mật khẩu:</b> ${sessionScope.account.passWord}</p>
            <p><b>Avatar:</b> ${sessionScope.account.avatar}</p>
            <p><b>Role ID:</b> ${sessionScope.account.roleid}</p>
            <p><b>Số điện thoại:</b> ${sessionScope.account.phone}</p>
            <p><b>Ngày tạo:</b> ${sessionScope.account.createdDate}</p>

            <br>
            <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
        </c:otherwise>
    </c:choose>

</body>
</html>
