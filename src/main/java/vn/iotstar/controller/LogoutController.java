//package vn.iotstar.controller;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import vn.iotstar.model.User;
//import vn.iotstar.service.UserService;
//import vn.iotstar.service.impl.UserServiceImpl;
//
//@SuppressWarnings("serial")
//@WebServlet(urlPatterns = "/login")
//public class LogoutController extends HttpServlet {
//
//    // Hằng số cho session và cookie
//    public static final String SESSION_USERNAME = "username";
//    public static final String COOKIE_REMEMBER = "username";
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        HttpSession session = req.getSession(false);
//
//        // Nếu đã login rồi thì chuyển sang waiting
//        if (session != null && session.getAttribute("account") != null) {
//            resp.sendRedirect(req.getContextPath() + "/waiting");
//            return;
//        }
//
//        // Check cookie
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (COOKIE_REMEMBER.equals(cookie.getName())) {
//                    session = req.getSession(true);
//                    session.setAttribute(SESSION_USERNAME, cookie.getValue());
//                    resp.sendRedirect(req.getContextPath() + "/waiting");
//                    return;
//                }
//            }
//        }
//
//        // Nếu chưa login -> forward về trang login.jsp
//        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        req.setCharacterEncoding("UTF-8");
//
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String remember = req.getParameter("remember");
//
//        boolean isRememberMe = "on".equals(remember);
//        String alertMsg = "";
//
//        // Check trống
//        if (username == null || username.isEmpty()
//                || password == null || password.isEmpty()) {
//            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
//            req.setAttribute("alert", alertMsg);
//            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
//            return;
//        }
//
//        // Gọi service kiểm tra tài khoản
//        UserService service = new UserServiceImpl();
//        User user = service.login(username, password);
//
//        if (user != null) {
//            // Login thành công
//            HttpSession session = req.getSession(true);
//            session.setAttribute("account", user);
//
//            if (isRememberMe) {
//                saveRememberMe(resp, username);
//            }
//            resp.sendRedirect(req.getContextPath() + "/waiting");
//        } else {
//            // Sai user/pass
//            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
//            req.setAttribute("alert", alertMsg);
//            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
//        }
//    }
//
//    private void saveRememberMe(HttpServletResponse response, String username) {
//        Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
//        cookie.setMaxAge(30 * 60); // 30 phút
//        response.addCookie(cookie);
//    }
//}
