package com.jdbc_hurix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.jdbc_hurix.dto.LanguageRequestDto;
import com.jdbc_hurix.service.LanguageService;

import lombok.extern.slf4j.Slf4j;

@Controller
@ResponseBody
@Slf4j
public class LanguageController<T> {

	@Autowired
	private LanguageService<T> service;

	@GetMapping(name = "GET_ALL_LANGUAGES_API", value = "/languages")
	public T getAllLanguages() {
		log.info("controller calling {}");
		return service.getAllLanguages();
	}

	@PostMapping(name = "SAVE_LANGUAGE_API", value = "/save")
	public T saveLanguage(@RequestBody LanguageRequestDto requestDto) {
		log.info("controller calling {}", "SAVE_LANGUAGE_API");
		return service.saveLanguages(requestDto);
	}

	@PutMapping(name = "UPDATE_LANGUAGE_BY_ID_API", value = "/update/{id}")
	public T updateLanguageById(@RequestBody LanguageRequestDto requestDto, @PathVariable("id") Long id) {
		log.info("controller calling {}", "UPDATE_LANGUAGE_BY_ID_API");
		return service.updateLanguageById(requestDto, id);
	}

	@DeleteMapping(name = "DELETE_LANGUAGE_BY_ID_API", value = "/delete/{id}")
	public T deleteLanguageById(@PathVariable("id") Long id) {
		log.info("controller calling {}", "DELETE_LANGUAGE_BY_ID_API");
		return service.deleteLanguageById(id);
	}

}
