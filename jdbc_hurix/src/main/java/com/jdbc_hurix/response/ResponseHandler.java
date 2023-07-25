package com.jdbc_hurix.response;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ResponseHandler {
	 private ResponseHandler(){

	    }
	    public static ResponseEntity<Object> generateResponse(String message, Integer code, String status, Object responseObj) {
	        Map<String, Object> map = new LinkedHashMap<>();
	        map.put("message", message);
	        map.put("code", code);
	        map.put("status", status);
	        map.put("data", responseObj);
	        return new ResponseEntity<>(map, HttpStatus.OK);
	    }
}
