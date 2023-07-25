package com.hurixtask.demo.serviceimpl;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hurixtask.dao.TestDao;
import com.hurixtask.demo.model.Test;
import com.hurixtask.demo.service.TestService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class TestServiceIMPL implements TestService
{
	@Autowired
	private TestDao dao;


	@Override
	public Test getResponse(HttpServletResponse response) {
		log.info("set the response");
		response.setHeader("DummyKey","DummyValue");
		response.setStatus(200);
		log.info("Set the response data into response class");
		Test test=new Test();
		test.setHttpStatus(response.getStatus());
		test.setResponseBody("Testing");
		test.setResponseHeader(response.getHeader("DummyKey"));
		log.info("getResponse End");
		return test;
	
	}

}
