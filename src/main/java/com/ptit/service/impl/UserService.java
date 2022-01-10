package com.ptit.service.impl;

import javax.inject.Inject;

import com.ptit.dao.IUserDAO;
import com.ptit.model.UserModel;
import com.ptit.service.IUserService;
import com.ptit.utils.HashFunctionUtil;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
		return userDAO.findByUsernameAndPasswordAndStatus(username, HashFunctionUtil.MD5(password), status);
//		return userDAO.findByUsernameAndPasswordAndStatus(username, password, status);
	}

	@Override
	public UserModel queryByStament(String username, String password, Integer status) {
		return userDAO.findByStament(username, HashFunctionUtil.MD5(password), status);
	}

}
