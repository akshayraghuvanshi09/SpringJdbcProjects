package com.hurixtask.demo.service;

import javax.servlet.http.HttpServletResponse;

import com.hurixtask.demo.model.Test;

public interface TestService {

	public Test getResponse(HttpServletResponse response);
}
