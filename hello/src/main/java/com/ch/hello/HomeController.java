package com.ch.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// @RequestMapping : 클라이언트의 요청을 받을때 사용하는 Annotation
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Locale locale, Model model) {	// Spring 자체적으로 제공하는 Model로 값을 View페이지에서 가져간다.
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		// "속성명", 속성값(Object)
		model.addAttribute("serverTime", formattedDate);
		
		// prefix와 suffix 값을 생략하고 View파일로 찾아간다.
		// 이외의 경로가 있다면 생략한 경로와 확장자를 제외한 나머지 경로값을 작성해 준다.
		return "home";
	}

	@RequestMapping("/color")
	public String color(Model model) {
		String[] color = { "red", "orange", "yellow", "green", "blue", "navy", "violet" };
		int num = (int) (Math.random() * 7);
		model.addAttribute("color", color[num]);
		return "color";
	}

	@RequestMapping("/gugu")
	public String gugu(Model model) {
		int num = (int) (Math.random() * 8) + 2;
//		int a = num / 0;
		model.addAttribute("num", num);
		return "gugu";
	}
	/*
	 * @ExceptionHandler(ArithmeticException.class) 
	 * public String err() { 
	 * return
	 * "arr-err"; }
	 */
}