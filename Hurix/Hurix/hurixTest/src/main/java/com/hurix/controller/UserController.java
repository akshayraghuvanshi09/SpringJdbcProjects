package com.hurix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.hurix.constant.ErrorMsg;
import com.hurix.response.BookUserResponse;
import com.hurix.response.PaginationResponse;
import com.hurix.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("static-access")
	@GetMapping("/get")
	public ResponseEntity<?> getBookList(@RequestParam(required = false, defaultValue = "10") Integer pageNo,
		@RequestParam(required = false, defaultValue = "0") Integer pageSize) {

		PaginationResponse paginationResponse = userService.getBookList(pageNo, pageSize);
		if (paginationResponse.getData() != null) {
			return new ResponseEntity<List<BookUserResponse>>(HttpStatus.OK).ok(paginationResponse);
		} else {
			return ResponseEntity.ok().body(ErrorMsg.REOCRD_NOT_FOUND);
		}

	}

}
