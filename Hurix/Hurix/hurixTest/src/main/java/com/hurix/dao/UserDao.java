package com.hurix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hurix.constant.SQLQuery;
import com.hurix.response.BookUserResponse;
import com.hurix.response.PaginationResponse;

@Repository
public class UserDao {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	JdbcTemplate template;

	public PaginationResponse getBookList(Integer pageSize, Integer pageNo) {
		log.info("inside getBookList");
//////////////////
		Integer totalRecords = template.queryForObject(SQLQuery.CountOfBookUser, Integer.class);
		int totalpage = 0;

		if (pageSize == null) {
			totalpage = 1;
		} else {
			totalpage = (int) Math.ceil((double) totalRecords / pageSize);
		}
/////////////////
		String query;

		if (pageSize == null || pageNo == null) {
			log.info("inside null condition");
			query = SQLQuery.bookListWithoutLimit;
		} else {

			query = SQLQuery.bookListWithLimit;
		}
		List<BookUserResponse> result = template.query(query, ps -> {
			if (!(pageSize == null || pageNo == null)) {
				ps.setInt(2, pageSize);
				ps.setInt(1, pageNo * pageSize);
			}
		}, new ResultSetExtractor<List<BookUserResponse>>() {

			@Override
			public List<BookUserResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<BookUserResponse> list = new ArrayList<BookUserResponse>();
				while (rs.next()) {
					BookUserResponse dbResponse = new BookUserResponse();
					dbResponse.setTitle(rs.getString("title"));
					dbResponse.setAuthor(rs.getString("author"));
					dbResponse.setName(rs.getString("name"));
					list.add(dbResponse);
				}
				return list;
			};
		});
//		return result;

		return new PaginationResponse(result, totalpage, totalRecords, pageNo, pageSize);

	}

}
