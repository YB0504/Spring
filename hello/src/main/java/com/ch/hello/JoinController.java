package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JoinController {
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	// @ModelAttribute : 양식 form에서 넘어온 값을 DTO객체를 생성하여 값을 받을 때 사용한다.
	@RequestMapping("/join")
	public String join(@ModelAttribute Member member, Model model) {
		
		System.out.println("id : " + member.getId());
		
		// model에 저장된 DTO객체를 view페이지로 전달해서
		// model로 가져간 member.필드명으로 출력한다.
		model.addAttribute("member", member);
		return "joinResult";
	}
}