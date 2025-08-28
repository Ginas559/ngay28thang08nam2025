package vn.iotstar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/profile"})
public class SessionProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false); // lấy session hiện có, không tạo mới
        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            out.print("Chào bạn, " + name + " đến với trang quản lý tài khoản");
            out.print("<br/><a href='" + req.getContextPath() + "/logout'>Đăng xuất</a>");
        } else {
            out.print("Xin vui lòng đăng nhập");
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
