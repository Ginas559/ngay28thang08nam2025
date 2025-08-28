<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Home</title>
</head>
<body>
    <h1>Chào mừng Manager - Nguyen Huu Trung Assistant!</h1>
    <p>Bạn đã đăng nhập với vai trò Manager (roleid=2).</p>
    <c:if test="${sessionScope.account != null}">
        <p>Chào ${sessionScope.account.fullName}!</p>
    </c:if>
</body>
</html>