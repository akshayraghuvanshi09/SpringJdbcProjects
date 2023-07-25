package com.jdbc_hurix.service;

import com.jdbc_hurix.dto.StepRequestDto;

public interface StepService<T> {
	public T saveStep(StepRequestDto requestDto);

	public T getStepById(Long id);
}
