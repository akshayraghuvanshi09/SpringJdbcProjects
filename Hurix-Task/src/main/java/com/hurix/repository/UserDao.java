package com.hurix.repository;

import java.sql.ResultSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hurix.helper.UserPaginationResponse;
import com.hurix.model.User;
import com.hurix.model.resultSetExrator.UserExtrator;
import com.hurix.utils.SqlQuries;

@Repository
public class UserDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@PostConstruct
	public void createTables() {
		jdbcTemplate.execute(SqlQuries.CREATE_TABLE_QUERY);
	}
	
	public int insertUser(User user) {
		
		String query = SqlQuries.CREATE_USER_QUERY;
		
		Object[] args = {user.getName(), user.getUsername(), user.getPassword(), user.getCity()};
		
		int noOfRowsInserted = jdbcTemplate.update(query,args);
		
		return noOfRowsInserted;
	}
	
	public UserPaginationResponse getAllUsers(String city, Integer pageNo, Integer pageSize, String sortBy, String sortDirection) {
		
		String query ="";
		
		if (city!= null ) {
			query = "SELECT * FROM employee_service.user WHERE city = ? Order by "+sortBy+" "+sortDirection+" limit ?, ? ";
//			query = "SELECT * FROM employee_service.user WHERE city = ? Order by ? ? limit ?, ?";
		}
		else {
			query = "SELECT * FROM employee_service.user Order by "+sortBy+" "+sortDirection+" limit ?, ? ";
		}
		
		List<User> userlist = jdbcTemplate.query(query, ps -> {
			 int count =1;
			
			if (city!=null) {
				ps.setString(count++, city);
			}
            	ps.setInt(count++, pageNo * pageSize);
                ps.setInt(count++, pageSize);
                System.out.println(ps.toString());

        }, new UserExtrator());

        Integer totalRecords = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER", Integer.class);
        int totalpage = 0;
        
        totalpage = (int) Math.ceil((double) totalRecords / pageSize);


        return new UserPaginationResponse(userlist, totalRecords, pageNo, pageSize, totalpage);

	}
}
