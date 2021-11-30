package com.ptit.service;

import java.util.List;

import com.ptit.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();

	CategoryModel findOne(Long id);

	CategoryModel findOneByCode(String code);
}
