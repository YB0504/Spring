package com.example.demo.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RestController
@Controller
public class SampleController {

	// 직접 브라우저로 결과 처리
	@RequestMapping("/hi")
	@ResponseBody 			// 요청한 브라우저로 요청을 돌려준다.
	public void hello(HttpServletResponse response) throws IOException {
		response.getWriter().print("Hello World~!!");
	}

	@RequestMapping("/abc")
	@ResponseBody
	public String abc() {
		return "hi abc";
	}

	// jsp파일 생성하여 처리
	// @ResponseBody가 없기 때문에 .jsp로 요청을 보낸다.
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello in");
		return "hello";
	}

	@RequestMapping("/gugu")
	// 입력되는 구구단값을 가져가기 위한 Model객체
	public String gugu(Model model) {
		Random r = new Random();
		int dan = r.nextInt(8) + 2; 		// 2 ~ 9단
		model.addAttribute("dan", dan);
		return "gugu";
	}
}
