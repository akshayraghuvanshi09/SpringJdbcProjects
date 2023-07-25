package com.jdbc_hurix.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc_hurix.constant.Query;
import com.jdbc_hurix.dto.LanguageRequestDto;
import com.jdbc_hurix.entity.Languages;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class LanguageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Languages> getAllLanguages() {
		List<Languages> query = jdbcTemplate.query(Query.languageList, RowsMapper.getAllLanguagesRowMapper());
		log.info("dao layer getalllanguage", query);
		return query;
	}

	public Integer saveLanguage(LanguageRequestDto requestDto) {
		int save = jdbcTemplate.update(Query.insertLanguage, requestDto.getLanguage(), requestDto.getLocale());
		log.info("dao layer saveLanguage", save);
		return save;
	}

	public Integer updateLanguageById(LanguageRequestDto requestDto, Long id) {
		int update = jdbcTemplate.update(Query.updateLanguageById, requestDto.getLanguage(), requestDto.getLocale(),
				id);
		log.info("dao layer updateLanguageById", update);
		return update;
	}

	public Integer deleteLanguageById(Long id) {
		int delete = jdbcTemplate.update(Query.deleteLanguageById, id);
		log.info("dao layer deleteLanguageById", delete);
		return delete;
	}
}
