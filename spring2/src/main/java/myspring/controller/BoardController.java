package myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.protocol.x.ReusableOutputStream;

import myspring.model.Board;
import myspring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	// 글 작성 폼
	@RequestMapping("boardform.do")
	public String boardform() {
		return "board/boardform";
	}

	// 글 작성
	@RequestMapping("boardwrite.do")
	public String boardwrite(@ModelAttribute Board board, Model model) {

		int result = service.insert(board);
		if (result == 1)
			System.out.println("글 작성 성공");

		model.addAttribute("result", result);

		return "board/insertresult";
	}

	// 글 목록
	// 기본 변수, 파생 변수 설정
	@RequestMapping("boardlist.do")
	public String boardlist(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		// 현재 페이지 번호 : 어노테이션 처리(@RequestParam)
		// @RequestParam(value = "page", defaultValue = "1") int page

		int limit = 10;

		// 페이지를 자르기 위한 시작,끝 번호
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		// 총 데이터 개수
		int listcount = service.getCount();
		System.out.println("listcount : " + listcount);

		List<Board> boardlist = service.getBoardList(page);
		System.out.println("boardlist : " + boardlist);

		// 총 페이지수
		// 각 블럭마다 페이지 수
		int pageCount = listcount / limit + ((listcount % 10 == 0) ? 0 : 1);

		int startPage = ((page - 1) / 10) * limit + 1;
		int endPage = startPage + 10 - 1;

		// 실제 존재하는 페이지까지만 출력
		if (endPage > pageCount)
			endPage = pageCount;

		// 필요한 값 가져가기
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return "board/boardlist";
	}
	
	// 상세 페이지 : 조회수 1증가 + 상세 정보
	@RequestMapping("boardcontent.do")
	public String boardcontent(@RequestParam("no") int no,
			  				   @RequestParam("page") String page,
			  				   Model model) {
		
		// 조회수 1증가
		service.updatecount(no);
		
		// 상세 정보
		Board board = service.getBoard(no);
		
		// 내용 줄바꿈 기능
		String content = board.getContent().replace("\n", "<br>");
		
		// 값 가져가기
		model.addAttribute("board", board);
		model.addAttribute("content", content);
		model.addAttribute("page", page);
		
		return "board/boardcontent";
	}
	
	// 수정 폼
	@RequestMapping("boardupdateform.do")
	public String boardupdateform(@RequestParam("no") int no,
								  @RequestParam("page") String page,
								  Model model) {
		
		// 상세 정보 구하기
		Board board = service.getBoard(no);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		
		return "board/boardupdateform";
	}
	
	// 글수정
	@RequestMapping("boardupdate.do")
	public String boardupdate(@ModelAttribute Board board,
							  @RequestParam("page") String page,
							  Model model) {
		int result = 0;
		Board db = service.getBoard(board.getNo());
		if(db.getPasswd().equals(board.getPasswd())) {
			result = service.update(board);
		}else {
			result = -1;
		}
		
		model.addAttribute("result", result);
		// 수정후에 상세페이지로 가려면 board내부의 no값이 필요하다.
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		
		return "board/updateresult";
	}
	
	// 삭제 폼
	@RequestMapping("boarddeleteform.do")
	public String boarddeleteform() {
		return "board/boarddeleteform";
	}
	
	// 글 삭제
	@RequestMapping("boarddelete.do")
	public String boarddelete(@ModelAttribute Board board,
							  @RequestParam("page") String page,
							  Model model) {
		int result = 0;
		Board db = service.getBoard(board.getNo());
		if(db.getPasswd().equals(board.getPasswd())) {
			result = service.delete(board.getNo());
		}else {
			result = -1;
		}
		
		model.addAttribute("result", result);
		model.addAttribute("page", page);
		
		return "board/deleteresult";
	}
	
}
