package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import vn.iotstar.model.Category;
import vn.iotstar.model.User;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/category", "/category/add", "/category/edit", "/category/delete"})
public class CategoryController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String url = req.getServletPath(); // lay URL
        switch (url) {
            case "/category":
                list(req, resp);
                break;
            case "/category/add":
            	req.getRequestDispatcher("/category-add.jsp").forward(req, resp);

                break;
            case "/category/edit":
                editForm(req, resp);
                break;
            case "/category/delete":
                delete(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String url = req.getServletPath();
        switch (url) {
            case "/category/add":
                insert(req, resp);
                break;
            case "/category/edit":
                update(req, resp);
                break;
        }
    }

    // hien danh sach category theo user
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("account");
        if (u == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        List<Category> list = cateService.findAll(u.getId());
        req.setAttribute("list", list);
        req.getRequestDispatcher("/category-list.jsp").forward(req, resp);
    }

    // form sua
    private void editForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category cate = cateService.get(id);
        req.setAttribute("cate", cate);
        req.getRequestDispatcher("/category-edit.jsp").forward(req, resp);
    }

    // them moi
    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String icons = req.getParameter("icons");

        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("account");

        Category cate = new Category();
        cate.setName(name);
        cate.setIcon(icons);
        cate.setUserId(u.getId());

        cateService.insert(cate);
        resp.sendRedirect(req.getContextPath() + "/category");
    }

    // cap nhat
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String icons = req.getParameter("icons");

        Category cate = new Category();
        cate.setId(id);
        cate.setName(name);
        cate.setIcon(icons);

        cateService.update(cate);
        resp.sendRedirect(req.getContextPath() + "/category");
    }

    // xoa
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        cateService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/category");
    }
}
