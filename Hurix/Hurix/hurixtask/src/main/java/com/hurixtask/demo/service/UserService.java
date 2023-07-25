package com.hurixtask.demo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hurixtask.demo.model.UserRequest;
import com.hurixtask.responsedto.UserResponseDTO;

public interface UserService {

	public UserResponseDTO testCalling(HttpServletRequest request,UserRequest user);
}
