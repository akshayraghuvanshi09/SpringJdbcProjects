package com.jdbc_hurix.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.jdbc_hurix.entity.Instructions;
import com.jdbc_hurix.entity.MetaData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StepRequestDto {

	@NotEmpty(message = "title can not be empty")
	private String title;

	@NotEmpty(message = "refId can not be empty")
	private String refId;

	private int kitabooId;

	@NotEmpty(message = "levelOfSupport can not be empty")
	private String levelOfSupport;
	@NotEmpty(message = "packageId can not be empty")
	private String packageId;

	@NotEmpty(message = "type can not be empty")
	private String type;

	@Valid
	private List<Instructions> instructions;

	@Valid
	private List<MetaData> metaData;
}
