package com.hurix.utils;

public class SqlQuries {

	public final static String CREATE_TABLE_QUERY = "CREATE TABLE if not exists user (id INT primary key auto_increment, name VARCHAR(50), username varchar(50), password varchar(50), city varchar(50))";

	public final static String CREATE_USER_QUERY = "INSERT into USER(name, username, password, city) VALUES(?,?,?,?)";
	
//	public final static String GET_ALL_USERS_QUERY = "SELECT * FROM hurix_database.user Order by "+sortBy+" "+sortDirection+" limit ?, ? ";
	
//	public final static String GET_ALL_USERS_BY_CITY_QUERY = "SELECT * FROM hurix_database.user where city =? Order by ? ? limit ?, ?";
	
//	public final static String TOTAL_NUMBER_OF_RECORDS_QUERY = "SELECT COUNT(*) FROM USER";
}
