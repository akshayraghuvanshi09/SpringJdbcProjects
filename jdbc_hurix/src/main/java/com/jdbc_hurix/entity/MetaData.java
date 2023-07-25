package com.jdbc_hurix.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaData {

	@NotEmpty(message = "course can not be empty")
	private String course;

	@NotEmpty(message = "theme can not be empty")
	private String theme;

	@NotEmpty(message = "description can not be empty")
	private String description;

	@NotEmpty(message = "keywords can not be empty")
	private String keywords;

	@NotEmpty(message = "language can not be empty")
	private String language;

	@NotEmpty(message = "levelOfSupport can not be empty")
	private String levelOfSupport;

	@NotEmpty(message = "searchSkills can not be empty")
	private String searchSkills;

	@NotNull(message = "showFeedback can not be null")
	private boolean showFeedback;

	@NotNull(message = "showResult can not be null")
	private boolean showResult;

}
