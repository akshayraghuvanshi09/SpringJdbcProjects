package com.jdbc_hurix.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc_hurix.dto.StepRequestDto;
import com.jdbc_hurix.service.StepService;

@RestController
@RequestMapping("/step/")
public class StepController<T> {

	@Autowired
	private StepService<T> service;

	@PostMapping(name = "SAVE_STEP_API", value = "save")
	public T saveStep(@RequestBody @Valid StepRequestDto requestDto) {
		return service.saveStep(requestDto);
	}

	@GetMapping(name = "GET_STEP_API_BY_ID", value = "get/{id}")
	public T getStepById(@PathVariable("id") Long id) {
		return service.getStepById(id);
	}

}
