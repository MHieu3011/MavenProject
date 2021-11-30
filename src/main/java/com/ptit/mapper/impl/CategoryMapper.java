package com.ptit.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ptit.mapper.RowMapper;
import com.ptit.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(resultSet.getLong("id"));
			categoryModel.setName(resultSet.getString("name"));
			categoryModel.setCode(resultSet.getString("code"));
			categoryModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				categoryModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			categoryModel.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getString("modifiedby") != null) {
				categoryModel.setModifiBy(resultSet.getString("modifiedby"));
			}
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
