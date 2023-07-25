package com.jdbc_hurix.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.jdbc_hurix.dto.StepRequestDto;
import com.jdbc_hurix.entity.Instructions;
import com.jdbc_hurix.entity.Languages;
import com.jdbc_hurix.entity.MetaData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RowsMapper {

	public static RowMapper<Languages> getAllLanguagesRowMapper() {
		RowMapper<Languages> rowMapper = (rs, rn) -> {

			Languages build = Languages.builder().id(rs.getLong("ID")).language(rs.getString("LANGUAGE"))
					.locale("LOCALE").build();
			log.info("rowNum={},build={}", build);
			return build;
		};
		return rowMapper;
	}

	public static RowMapper<StepRequestDto> getByStepRowMapper() {
		RowMapper<StepRequestDto> rowMapper = (rs, rn) -> {

			Instructions instructionsRequestDto = Instructions.builder().student(rs.getString("st.student"))
					.language(rs.getString("st.language")).teacher(rs.getString("st.teacher")).build();

			List<Instructions> instructionsRequestDtos = new ArrayList<>();
			instructionsRequestDtos.add(instructionsRequestDto);

			MetaData metaDataRequestDto = MetaData.builder().course(rs.getString("sp.course"))
					.description(rs.getString("sp.description")).keywords("sp.keywords")
					.language(rs.getString("sp.language")).levelOfSupport(rs.getString("sp.level_of_support"))
					.searchSkills("sp.search_skills").showFeedback(rs.getBoolean("sp.show_feedback"))
					.showResult(rs.getBoolean("sp.show_result")).theme(rs.getString("sp.theme")).build();

			List<MetaData> metaDataRequestDtos = new ArrayList<>();
			metaDataRequestDtos.add(metaDataRequestDto);
			StepRequestDto build = StepRequestDto.builder().refId(rs.getString("s.ref_id"))
					.kitabooId(rs.getInt("s.kitaboo_id")).levelOfSupport(rs.getString("s.level_of_support"))
					.packageId(rs.getString("s.package_id")).title(rs.getString("s.title")).type(rs.getString("s.type"))
					.instructions(instructionsRequestDtos).metaData(metaDataRequestDtos).build();
			log.info("rowNum={},build={}", build);
			return build;
		};
		return rowMapper;
	}
}
