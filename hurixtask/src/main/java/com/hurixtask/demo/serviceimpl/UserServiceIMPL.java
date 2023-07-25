package com.hurixtask.demo.serviceimpl;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hurixtask.dao.UserDao;
import com.hurixtask.demo.model.UserRequest;
import com.hurixtask.demo.service.UserService;
import com.hurixtask.responsedto.UserResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceIMPL<T> implements UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public UserResponseDTO testCalling(HttpServletRequest request, UserRequest user) {
		log.info("call getRequestHeaders Method");
		Map<String, String> requestHeaders = getRequestHeaders(request);
		log.info("call getRequestParameters Method");
		Map<String, String> requestParameters = getRequestParameters(request);
		log.info("Call to Another Service");
		ResponseEntity<String> response=restTemplate.getForEntity(user.getUrl(),String.class);
		log.info("return from another Service { " + response + " }");
		log.info("Map the response in UserResponseDTO");
		
		UserResponseDTO dto = new UserResponseDTO<>();
		dto.setUrl(user.getUrl());
		dto.setMethod(user.getMethod());
		dto.setRequestheader(requestHeaders);
		dto.setQueryParameter(requestParameters);
		dto.setRequestbody(user.getBody());
		dto.setBody(response.getBody());
		dto.setHeader(response.getHeaders());
		dto.setHttpStatus(response.getStatusCode());
		dto.setHttpStatusValue(response.getStatusCodeValue());
	
			
		log.info("return the UserResponseDTO");
		return dto;
	}

	private Map<String, String> getRequestHeaders(HttpServletRequest request) {
		Map<String, String> headers = new HashMap<>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			headers.put(headerName, headerValue);
		}
		return headers;
	}

	private Map<String, String> getRequestParameters(HttpServletRequest request) {
		Map<String, String> parameters = new HashMap<>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			String parameterValue = request.getParameter(parameterName);
			parameters.put(parameterName, parameterValue);
		}
		return parameters;
	}

	
}
