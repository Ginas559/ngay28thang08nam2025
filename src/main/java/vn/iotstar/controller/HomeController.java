package vn.iotstar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home", "/trangchu" })

public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Buoc 1: Nhan tham so cua request neu cho
		String name = req.getParameter("ten");
		String name2 = req.getParameter("ho");
		// Buoc 2: Xu ly tham so
		// Buoc 3: Phan hoi ket qua
		resp.setContentType("text/html");// dinh nghia dang tra ve la loai gi

		PrintWriter out = resp.getWriter();
		out.println("<p>Xin chao " + name + "</p>");
		out.println("<p>Xin chao " + name2 + "</p>");
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Buoc 1: Nhan tham so cua request neu cho
		String name = req.getParameter("ten");
		String name2 = req.getParameter("ho");
		// Buoc 2: Xu ly tham so
		// Buoc 3: Phan hoi ket qua
		resp.setContentType("text/html");// dinh nghia dang tra ve la loai gi

		PrintWriter out = resp.getWriter();
		out.println("<p>Xin chao " + name + "</p>");
		out.println("<p>Xin chao " + name2 + "</p>");
		out.close();
	}

}
