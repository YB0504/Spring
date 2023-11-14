package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("boardform")
	public String main() {
		return "boardform";
	}
	
	@RequestMapping("boardInsert")
	public String boardInsert(Board board) {
		int result = service.boardInsert(board);
		if(result == 1) System.out.println("글 작성 성공");
		
		return "redirect:boardlist";
	}
	
	@RequestMapping("boardlist")
	public String boardlist(Model model){
		List<Board> list = service.list();
		
		model.addAttribute("list", list);
		
		return "boardlist";
	}
}
