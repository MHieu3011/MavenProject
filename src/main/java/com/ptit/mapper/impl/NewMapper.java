package com.ptit.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ptit.mapper.RowMapper;
import com.ptit.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel newModel = new NewModel();
			newModel.setId(resultSet.getLong("id"));
			newModel.setTitle(resultSet.getString("title"));
			newModel.setThumbnail(resultSet.getString("thumbnail"));
			newModel.setShortdescription(resultSet.getString("shortdescription"));
			newModel.setContent(resultSet.getString("content"));
			newModel.setCategoryId(resultSet.getLong("categoryid"));
			newModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				newModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			newModel.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getString("modifiedby") != null) {
				newModel.setModifiBy(resultSet.getString("modifiedby"));
			}
			return newModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
