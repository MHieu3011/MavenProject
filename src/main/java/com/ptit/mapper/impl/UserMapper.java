package com.ptit.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ptit.mapper.RowMapper;
import com.ptit.model.RoleModel;
import com.ptit.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(resultSet.getLong("id"));
			userModel.setUsername(resultSet.getString("username"));
			userModel.setPassword(resultSet.getString("password"));
			userModel.setFullname(resultSet.getString("fullname"));
			userModel.setStatus(resultSet.getInt("status"));
			userModel.setRoleId(resultSet.getLong("roleid"));
			userModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				userModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			userModel.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getString("modifiedby") != null) {
				userModel.setModifiBy(resultSet.getString("modifiedby"));
			}
			try {
				RoleModel role = new RoleModel();
				role.setName(resultSet.getString("name"));
				role.setCode(resultSet.getString("code"));
				userModel.setRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
