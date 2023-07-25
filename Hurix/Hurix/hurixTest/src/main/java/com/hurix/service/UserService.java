package com.hurix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurix.dao.UserDao;
import com.hurix.response.PaginationResponse;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public PaginationResponse getBookList(Integer pageNo, Integer pageSize) {

		return userDao.getBookList(pageSize, pageNo);
	}

}
