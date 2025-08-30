<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Category</title>
</head>
<body>
    <h2>Sửa Category</h2>
    <form action="${pageContext.request.contextPath}/category/edit" method="post">
        <input type="hidden" name="id" value="${cate.id}">
        <label>Tên:</label>
        <input type="text" name="name" value="${cate.name}"><br>
        <label>Icons:</label>
        <input type="text" name="icons" value="${cate.icon}"><br>
        <button type="submit">Cập nhật</button>
    </form>
</body>
</html>
