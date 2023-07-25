package com.jdbc_hurix.service;

import com.jdbc_hurix.dto.LanguageRequestDto;

public interface LanguageService<T> {
	public T getAllLanguages();

	public T saveLanguages(LanguageRequestDto dto);

	public T updateLanguageById(LanguageRequestDto requestDto, Long id);
	
	public T deleteLanguageById(Long id);
}
