package com.ptit.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.ptit.dao.ICategoryDAO;
import com.ptit.model.CategoryModel;
import com.ptit.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public CategoryModel findOne(Long id) {
		return categoryDAO.findOne(id);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		return categoryDAO.findOneByCode(code);
	}

}
