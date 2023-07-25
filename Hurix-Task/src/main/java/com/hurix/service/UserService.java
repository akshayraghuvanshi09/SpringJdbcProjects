package com.hurix.service;

import com.hurix.helper.UserPaginationResponse;
import com.hurix.model.User;

public interface UserService {

	Boolean createUser(User user);
	
	UserPaginationResponse getAllUsers(String city, Integer pageNo, Integer pageSize, String sortBy, String sortDirection);
}
