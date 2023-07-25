package com.jdbc_hurix.entity;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instructions {
	@NotEmpty(message = "student can not be empty")
	private String student;

	@NotEmpty(message = "teacher can not be empty")
	private String teacher;

	@NotEmpty(message = "language can not be empty")
	private String language;
}
