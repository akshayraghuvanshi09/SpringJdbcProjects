package com.hurix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
	private String user;
	private String userName;
	private String password;
	private String city;
	
}
