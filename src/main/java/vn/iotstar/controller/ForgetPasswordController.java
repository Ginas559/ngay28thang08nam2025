package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forgetpassword")
public class ForgetPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // hien form quen mat khau
        req.getRequestDispatcher("/forgetpassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String alertMsg = "";

        UserService service = new UserServiceImpl();
        User user = service.get(username);

        if (user != null) {
            // tim thay user thi hien mat khau
            alertMsg = "Mat khau cua ban la: " + user.getPassWord();
        } else {
            // khong tim thay user
            alertMsg = "Tai khoan khong ton tai";
        }

        req.setAttribute("alert", alertMsg);
        req.getRequestDispatcher("/forgetpassword.jsp").forward(req, resp);
    }
}
