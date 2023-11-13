package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController : @Controller + @ResponseBody
// DTO객체, List를 JSON으로 변환 해주는 역할을 한다.(jackson라이브러리)
public class HelloController {

	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Boot";
	}
}
