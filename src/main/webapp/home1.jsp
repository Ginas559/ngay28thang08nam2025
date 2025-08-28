<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
</head>
<body>
    <h1>Chào mừng Admin - Nguyen Huu Trung!</h1>
    <p>Bạn đã đăng nhập với vai trò Admin (roleid=1).</p>
    <c:if test="${sessionScope.account != null}">
        <p>Chào ${sessionScope.account.fullName}!</p>
    </c:if>
    <p><a href="${pageContext.request.contextPath}/login">Đăng nhập lại</a> | <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></p>
    <%@ include file="../topbar.jsp" %>
</body>
</html>