<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Category</title>
</head>
<body>
    <h2>Thêm Category</h2>
    <form action="${pageContext.request.contextPath}/category/add" method="post">
        <label>Tên:</label>
        <input type="text" name="name"><br>
        <label>Icons:</label>
        <input type="text" name="icons"><br>
        <button type="submit">Lưu</button>
    </form>
</body>
</html>
