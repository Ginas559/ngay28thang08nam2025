package vn.iotstar.controller;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // forward sang trang register.jsp
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        String alertMsg = "";
        UserService service = new UserServiceImpl();

        // Kiểm tra rỗng
        if (username == null || fullname == null || email == null 
                || phone == null || password == null 
                || username.isEmpty() || fullname.isEmpty() 
                || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            alertMsg = "Các trường không được để trống!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        // Chỉ kiểm tra trùng username
        if (service.checkExistUsername(username)) {
            alertMsg = "Tên đăng nhập đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        // Nếu mọi thứ OK thì insert
        User user = new User(email, username, fullname, password, 
                             null, 3, phone, new Date()); 
        // avatar = null, roleid = 3 (user mặc định)

        service.insert(user);

        // Sau khi đăng ký thành công → chuyển sang trang login.jsp
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
