package com.hurix.model.resultSetExrator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.hurix.model.User;

public class UserExtrator implements ResultSetExtractor<List<User>> {

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		ArrayList<User> userList = new ArrayList<>();
		
		while (rs.next()) {
			
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setCity(rs.getString("city"));
			
			userList.add(user);
		}
		return userList;
	}

}

