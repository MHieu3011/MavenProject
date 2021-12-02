package com.ptit.dao;

import com.ptit.model.UserModel;

public interface IUserDAO {
	UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
