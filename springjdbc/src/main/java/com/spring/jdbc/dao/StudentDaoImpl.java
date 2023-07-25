package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// insert query
		String sql = "insert into student values(?, ?, ?)";
		return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getCity());
	}

	public int update(Student student) {
		// update query
		String sql = "update student set name=?, city=? where id=?";
		return this.jdbcTemplate.update(sql, student.getName(), student.getCity(), student.getId());
	}

	public int delete(Student student) {
		// delete query
		String sql = "delete from student where id=?";
		return this.jdbcTemplate.update(sql, student.getId());
	}

	public Student getStudent(int studentId ) {
		String sql = "select * from student where id= ?";
		Student student = this.jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
			
		}, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		// select all records from DB
		String sql = "select * from student";
		List<Student> students = this.jdbcTemplate.query(sql, new RowMapper <Student>(){

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
		});
		return students;
	}

	// implementing rowMapper using another class (RowMapperImpl)
//	public Student getStudent(int studentId) {
//		// selecting single row query
//		String sql = "select * from student where id=?";
//		RowMapper<Student> rowMapper =  new RowMapperImpl();
//		Student student = this.jdbcTemplate.queryForObject(sql, rowMapper, studentId );
//		return student;
//	}
	
	
	
}
