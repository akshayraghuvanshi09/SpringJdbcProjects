package com.testingmapping.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.testingmapping.demo.entity.Admin;
import com.testingmapping.demo.repo.AdminRepo;
import com.testingmapping.demo.requestdto.AdminRequestDTO;
import com.testingmapping.demo.responsedto.AdminResponseDTO;
import com.testingmapping.demo.responsedto.CommonResponseDTO;
import com.testingmapping.demo.service.AdminService;
@Service
public class AdminServiceIMPL<T> implements AdminService<T>
{

	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private ModelMapper mapper;
	@SuppressWarnings("unchecked")
	@Override
	public T save(AdminRequestDTO adminRequestDTO) {
		Admin map = mapper.map(adminRequestDTO,Admin.class);
		adminRepo.save(map);
		return (T) new CommonResponseDTO("Success",200,mapper.map(map,AdminResponseDTO.class));
	}

	@Override
	public T getSingleById(Integer id) {
		Optional<Admin> findById = adminRepo.findById(id);
		if(findById.isPresent())
		{
			return (T) new CommonResponseDTO("Success",200,mapper.map(findById,AdminResponseDTO.class));
		}
		return (T) new CommonResponseDTO("Success",200,mapper.map(findById,null));
	}

	@Override
	public List<T> getAll() {
		List<Admin> findAll = adminRepo.findAll();
		List<AdminResponseDTO> collect = findAll.stream().map(e-> mapper.map(e,AdminResponseDTO.class)).collect(Collectors.toList());
		return (List<T>) collect;
	}

	@Override
	public T updateById(Integer id, AdminRequestDTO adminRequestDTO) {

		return null;
	}

	@Override
	public T deleteById(Integer id) {

		return null;
	}

	@Override
	public T deleteAll() {

		return null;
	}

}
