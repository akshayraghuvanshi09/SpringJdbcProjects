package com.jdbc_hurix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jdbc_hurix.constant.Query;
import com.jdbc_hurix.dto.StepRequestDto;
import com.jdbc_hurix.entity.Instructions;
import com.jdbc_hurix.entity.MetaData;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StepDao {

	@Autowired
	private JdbcTemplate template;

	public void saveStep(StepRequestDto requestDto) {
		log.info("dao layer saveStep starting");
		KeyHolder holder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(Query.saveStep,new String[]{"id"});
				pstmt.setInt(1,requestDto.getKitabooId());
				pstmt.setString(2,requestDto.getLevelOfSupport());
				pstmt.setString(3,requestDto.getPackageId());
				pstmt.setString(4,requestDto.getRefId());
				pstmt.setString(5,requestDto.getTitle());
				pstmt.setString(6,requestDto.getType());
				return pstmt;
			}
		}, holder);

		Number key = holder.getKey();
		System.err.println(key+"    "+key.intValue());
		Long id = template.queryForObject(Query.getLastIndexId, Long.class);
		saveChildEntities(requestDto, key.longValue());
		log.info("dao layer saveStep ending");

	}

	public void saveChildEntities(StepRequestDto requestDto, Long id) {
		log.info("saveChildEntities method calling start");
			template.batchUpdate(Query.saveInstructions, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1,requestDto.getInstructions().get(i).getLanguage());
					ps.setString(2,requestDto.getInstructions().get(i).getStudent());
					ps.setString(3,requestDto.getInstructions().get(i).getTeacher());
					ps.setLong(4,id);
				}

				@Override
				public int getBatchSize() {
					return requestDto.getInstructions().size();
				}
			});

			template.batchUpdate(Query.saveMetaData, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1,requestDto.getMetaData().get(i).getCourse());
					ps.setString(2,requestDto.getMetaData().get(i).getDescription());
					ps.setString(3,requestDto.getMetaData().get(i).getKeywords());
					ps.setString(4,requestDto.getMetaData().get(i).getLanguage());
					ps.setString(5,requestDto.getMetaData().get(i).getLevelOfSupport());
					ps.setString(6,requestDto.getMetaData().get(i).getSearchSkills());
					ps.setBoolean(7,requestDto.getMetaData().get(i).isShowFeedback());
					ps.setBoolean(8,requestDto.getMetaData().get(i).isShowResult());
					ps.setString(9,requestDto.getMetaData().get(i).getTheme());
					ps.setLong(10,id);
				}

				@Override
				public int getBatchSize() {
					return requestDto.getMetaData().size();
				}
			});
	}

	public Integer checkDuplicateForRefId(String refId) {
		Integer totalRecordsRefId = template.queryForObject(Query.countByRefId, Integer.class, refId);
		return totalRecordsRefId;
	}

	public Integer checkDuplicateForKitabooId(int kitabooId) {
		Integer totalRecordsKitabooId = template.queryForObject(Query.countByKitabooId, Integer.class, kitabooId);
		return totalRecordsKitabooId;
	}


	public List<StepRequestDto> getByIdStep(Long id) {
		log.info("getByIdStep method calling start");
		List<StepRequestDto> query = template.query(Query.getStepById, RowsMapper.getByStepRowMapper(), id);
		log.info("getByIdStep method calling end");
		return query;
	}

}
