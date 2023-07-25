package com.testingmapping.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testingmapping.demo.requestdto.AdminRequestDTO;
@Service
public interface AdminService<T> 
{

	T save(AdminRequestDTO adminRequestDTO);
	T getSingleById(Integer id);
	List<T> getAll();
	T updateById(Integer id,AdminRequestDTO adminRequestDTO);
	T deleteById(Integer id);
	T deleteAll();
	
}
