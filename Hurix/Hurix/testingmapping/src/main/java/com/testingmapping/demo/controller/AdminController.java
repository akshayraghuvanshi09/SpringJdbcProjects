package com.testingmapping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testingmapping.demo.requestdto.AdminRequestDTO;
import com.testingmapping.demo.service.AdminService;

@RestController
public class AdminController<T> {

	@Autowired
	private AdminService<T> adminService;
	
	@PostMapping("/saveAdmin")
	public T saveAdmin(@RequestBody AdminRequestDTO adminRequestDTO)
	{
		return adminService.save(adminRequestDTO);
	}
	
	@GetMapping("/getAdminById/{id}")
	public T getAdminById(@PathVariable("id") Integer id)
	{
		return adminService.getSingleById(id);
	}
	
	@GetMapping("/getAll")
	public List<T> getAllAdmin()
	{
		return adminService.getAll();
	}
	
	@PutMapping("/updateAdmin/{id}")
	public T updateAdmin(@PathVariable("id") Integer id,@RequestBody AdminRequestDTO adminRequestDTO)
	{
		return adminService.updateById(id, adminRequestDTO);
	}
	
	@DeleteMapping("/deleteSingleAdmin/{id}")
	public T deleteSingleAdmin(@PathVariable("id") Integer id)
	{
		return adminService.deleteById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public T deleteAllAdmin()
	{
		return adminService.deleteAll();
	}
}
