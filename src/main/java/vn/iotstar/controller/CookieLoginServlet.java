package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cookie-login"})
public class CookieLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Xử lý GET: forward về index.html
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/index.html").forward(req, resp);
	}

	// Xử lý POST: nhận dữ liệu từ form login
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		// Lấy dữ liệu từ form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");

		if ("trung".equals(user) && "123".equals(pass)) {
			// Tạo cookie username
			Cookie cookie = new Cookie("username", user);
			// Thiết lập thời gian sống của cookie: 30 giây
			cookie.setMaxAge(30);
			// Thêm cookie vào response
			resp.addCookie(cookie);
			// Chuyển hướng sang HelloServlet
			resp.sendRedirect(req.getContextPath() + "/hello");
		} else {
			// Nếu sai thì quay lại form login
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
