package com.testingmapping.demo.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommonResponseDTO {

	private String Status;
	private Integer statusCode;
	private Object data;
}
