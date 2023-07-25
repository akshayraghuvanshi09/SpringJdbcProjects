package com.hurixtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class HurixtaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HurixtaskApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public ObjectMapper mapper()
	{
		return new ObjectMapper();
	}
}
