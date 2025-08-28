package vn.iotstar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello", "/xin-chao" })
public class CookieHelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String name = "";

		// Nhận cookie từ client gửi lên
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("username".equals(c.getName())) {
					name = c.getValue();
					break;
				}
			}
		}

		if (name.isEmpty()) {
			// Nếu không có cookie thì quay lại trang login
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// Hiển thị kết quả ra trình duyệt
		out.println("<h2>Xin chào, " + name + "!</h2>");
	}
}
