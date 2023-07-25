package com.hurix.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurix.helper.UserPaginationResponse;
import com.hurix.model.User;
import com.hurix.repository.UserDao;
import com.hurix.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Boolean createUser(User user) {
		int isUserCreated = userDao.insertUser(user);
		if (isUserCreated>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public UserPaginationResponse getAllUsers(String city, Integer pageNo, Integer pageSize, String sortBy,
			String sortDirection) {
		return userDao.getAllUsers(city, pageNo, pageSize, sortBy, sortDirection);
	}

}
