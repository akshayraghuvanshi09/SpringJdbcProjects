package com.hurixtask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hurixtask.demo.model.UserRequest;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Integer saveUser(UserRequest requestDto) {
		return null;
	}
}
