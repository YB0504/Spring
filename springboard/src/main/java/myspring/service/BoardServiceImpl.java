package myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.dao.BoardDAOImpl;
import myspring.model.BoardBean;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAOImpl boardDao;
	

	/* 게시판 저장 */
	public void insert(BoardBean b) throws Exception {
		boardDao.insertBoard(b);
	}
	
	// 게시물 갯수	
	@Override
	public int getListCount() throws Exception {		
		return boardDao.getListCount();
	}

	// 게시판 목록
	@Override
	public List getBoardList(int page) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(page);
	}

	/* 조회수 증가 */
	public void hit(int board_num) throws Exception {
		boardDao.boardHit(board_num); // 조회수 증가
	}
	

	/* 상세정보 */
	public BoardBean board_cont(int board_num) throws Exception {

		BoardBean board = boardDao.getBoardCont(board_num);

		return board;
	}

	
	/* 게시판 수정 */
	public void edit(BoardBean b) throws Exception {			
		boardDao.boardEdit(b);
	}
	

	/* 게시판 삭제 */
	public void del_ok(int board_num) throws Exception{			
		boardDao.boardDelete(board_num);		
	}
	

	/* 게시판 댓글 달기 */
	public void reply_ok(BoardBean b) throws Exception {

		// update SQL을 실행하는 DAO메소드
		boardDao.refEdit(b); // 기존 댓글 board_re_seq값 1증가
		
		// 댓글 작성하는 insert SQL을 위한 1 증가된 값을 미리 저장
		b.setBoard_re_lev(b.getBoard_re_lev() + 1);
		b.setBoard_re_seq(b.getBoard_re_seq() + 1);

		// 댓글 작성하는 insert SQL을 실행하는 DAO메소드 
		boardDao.boardReplyOk(b);
	}

}
