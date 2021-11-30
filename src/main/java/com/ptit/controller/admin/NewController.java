package com.ptit.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ptit.constant.SystemConstant;
import com.ptit.model.NewModel;
import com.ptit.paging.PageRequest;
import com.ptit.paging.Pageble;
import com.ptit.service.INewService;
import com.ptit.sort.Sorter;
import com.ptit.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModel newModel = FormUtil.toModel(NewModel.class, req);
		Pageble pageble = new PageRequest(newModel.getPage(), newModel.getMaxPageItem(),
				new Sorter(newModel.getSortName(), newModel.getSortBy()));
		newModel.setTotalItem(newService.getTotalItem());
		newModel.setTotalPage((int) Math.ceil((double) newModel.getTotalItem() / newModel.getMaxPageItem()));
		newModel.setListResult(newService.findAll(pageble));
		req.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(req, resp);
	}
}
