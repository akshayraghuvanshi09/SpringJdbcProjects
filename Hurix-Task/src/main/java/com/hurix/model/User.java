package com.hurix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	private Integer id;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String city;
}
