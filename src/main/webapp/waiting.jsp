<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vn.iotstar.model.User" %>
<%
    User user = (User) session.getAttribute("account");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h2>Xin chào, <%= user.getFullName() %>!</h2>
    <p>Bạn đã đăng nhập thành công.</p>
    <a href="<%= request.getContextPath() %>/logout">Đăng xuất</a>
</body>
</html>
