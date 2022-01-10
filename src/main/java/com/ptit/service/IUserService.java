package com.ptit.service;

import com.ptit.model.UserModel;

public interface IUserService {
	UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);

	UserModel queryByStament(String username, String password, Integer status);
}
