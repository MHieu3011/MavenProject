package com.ptit.dao;

import java.util.List;

import com.ptit.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();

	CategoryModel findOne(Long id);

	CategoryModel findOneByCode(String code);
}
