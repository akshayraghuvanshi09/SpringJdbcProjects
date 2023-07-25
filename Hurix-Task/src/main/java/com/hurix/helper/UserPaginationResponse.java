package com.hurix.helper;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPaginationResponse {

	private Object data;
	
	private Integer totalRecords;
	
	private Integer currentPage;
	
	private Integer pageSize;
	
	private Integer totalPages;
}
