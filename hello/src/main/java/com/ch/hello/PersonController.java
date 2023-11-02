package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	
	// @RequestParam("name")
	// 1. 개별적으로 전달되는 name값을 받을 때 사용되는 Annotation
	// 2. request.getParameter("name")와 같은 역할을 수행한다.
	@RequestMapping("/addr")
	public String addr(@RequestParam("name") String name,
					   @RequestParam("addr") String addr,
					   Model model) {
		
		System.out.println("name : " + name);
		System.out.println("addr : " + addr);
		
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}

	// @ModelAttribute가 생략되어있다.
	@RequestMapping("/addr2")
	public String addr2(Person p, Model model) {
		model.addAttribute("person", p);
		return "addr2";
	}
}