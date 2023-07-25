package com.hurixtask.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hurixtask.demo.model.Test;
import com.hurixtask.demo.service.TestService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
 
	@Autowired
	private TestService service;
	
	@GetMapping("/calledService")
	public Test testService(HttpServletResponse response) {
		log.info("call getResponse Service");
		return service.getResponse(response);
	}
}
