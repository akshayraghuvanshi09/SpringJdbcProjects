package com.hurixtask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hurixtask.demo.model.Test;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class TestDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Integer saveUser(Test requestDto) {
		
		return null;
	}
}
