package vn.iotstar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session-login"})
public class SessionLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("trungnh".equals(username) && "123".equals(password)) {
            // Tạo session và lưu thông tin user
            HttpSession session = req.getSession();
            session.setAttribute("name", username);

            out.print("Chào mừng bạn, " + username);
            // Redirect sang Profile
            resp.sendRedirect(req.getContextPath() + "/profile");
        } else {
            out.print("Tài khoản hoặc mật khẩu không chính xác");
            req.getRequestDispatcher("index.html").include(req, resp);
        }
    }
}
