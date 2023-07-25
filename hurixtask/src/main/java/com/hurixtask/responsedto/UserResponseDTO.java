package com.hurixtask.responsedto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO<T> {

	private String url;
	private String method;
	private Map<String,String> requestheader;
	private Map<String,String> queryParameter;
	private String requestbody;
	private T httpStatus;
	private T body;
	private T header;
	private T httpStatusValue;
	
}
