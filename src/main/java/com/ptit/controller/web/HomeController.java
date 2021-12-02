package com.ptit.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.model.UserModel;
import com.ptit.service.ICategoryService;
import com.ptit.service.INewService;
import com.ptit.service.IUserService;
import com.ptit.utils.FormUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("testCategoryModel", categoryService.findAll());
		req.setAttribute("testNewModel", newService.findByCategoryId(2L));
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findByUsernameAndPasswordAndStatus(model.getUsername(), model.getPassword(), 1);
			if (model != null) {
				if (model.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				} else if (model.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
			}
		}
	}
}
