<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
</head>
<body>
    <h2>Danh sách Category</h2>
    <a href="${pageContext.request.contextPath}/category/add">Thêm mới</a>
    <br><br>
    <table border="1" width="100%">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Icons</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach items="${list}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.icon}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/category/edit?id=${c.id}">Sửa</a> |
                    <a href="${pageContext.request.contextPath}/category/delete?id=${c.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
