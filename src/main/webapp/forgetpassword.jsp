<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quen mat khau</title>
</head>
<body>

<h2>Quen mat khau</h2>
<c:if test="${alert != null}">
    <h3 style="color:red">${alert}</h3>
</c:if>

<form action="forgetpassword" method="post">
    <label>Nhap username:</label>
    <input type="text" name="username" placeholder="Username">
    <br>
    <button type="submit">Lay lai mat khau</button>
</form>

<a href="login.jsp">Quay lai dang nhap</a>

</body>
</html>
