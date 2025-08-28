<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Hủy session hiện tại
    if (session != null) {
        session.invalidate();
    }

    // Chuyển hướng về trang login (hoặc trang chủ)
    response.sendRedirect(request.getContextPath() + "/login.jsp");
%>
