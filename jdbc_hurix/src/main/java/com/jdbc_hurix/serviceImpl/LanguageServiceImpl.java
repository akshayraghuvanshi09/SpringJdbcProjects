package com.jdbc_hurix.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jdbc_hurix.constant.Messages;
import com.jdbc_hurix.dao.LanguageDao;
import com.jdbc_hurix.dto.LanguageRequestDto;
import com.jdbc_hurix.entity.Languages;
import com.jdbc_hurix.response.CommonResponse;
import com.jdbc_hurix.response.LanguagesResponse;
import com.jdbc_hurix.service.LanguageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LanguageServiceImpl<T> implements LanguageService<T> {

	@Autowired
	private LanguageDao dao;

	@Override
	public T getAllLanguages() {
		try {
			List<Languages> languages = dao.getAllLanguages();
			if (!languages.isEmpty()) {
				log.info("data fetch success", languages);
				LanguagesResponse response = LanguagesResponse.builder().languages(languages).build();
				return (T) response;
			} else {
				log.info("data not found", languages);
				return (T) new CommonResponse(Messages.NOT_FOUND, HttpStatus.NOT_FOUND.value());

			}
		} catch (Exception e) {
			return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());

		}

	}

	@Override
	public T saveLanguages(LanguageRequestDto dto) {
		try {
			Integer saveLanguage = dao.saveLanguage(dto);
			log.info("saveLanguages() mehtod calling", "data save successfully {}");
			return (T) new CommonResponse(Messages.SUCCESS, HttpStatus.OK.value());
		} catch (Exception e) {
			log.error("saveLanguages() mehtod calling {}", e);
			return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public T updateLanguageById(LanguageRequestDto requestDto, Long id) {

		try {
			Integer updateLanguage = dao.updateLanguageById(requestDto, id);
			if (updateLanguage > 0) {
				log.info("updateLanguageById() mehtod calling {}", "Data Updated !!");
				return (T) new CommonResponse(Messages.UPDATE_SUCCESS, HttpStatus.OK.value());
			} else {
				log.info("updateLanguageById() mehtod calling {}", "id not found!!");
				return (T) new CommonResponse(Messages.VALID_ID, HttpStatus.BAD_REQUEST.value());

			}
		} catch (Exception e) {
			log.error("updateLanguageById() mehtod calling {}", e);
			return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public T deleteLanguageById(Long id) {
		try {

			int delete = dao.deleteLanguageById(id);
			if (delete > 0) {
				log.info("deleteLanguageById() mehtod calling {}", "Data Deleted !!");
				return (T) new CommonResponse(Messages.DELETE_SUCCESS, HttpStatus.OK.value());
			} else {
				log.info("deleteLanguageById() mehtod calling {}", "id not found !!");
				return (T) new CommonResponse(Messages.VALID_ID, HttpStatus.BAD_REQUEST.value());

			}
		} catch (Exception e) {
			log.error("deleteLanguageById() mehtod calling {}", e);
			return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

}
