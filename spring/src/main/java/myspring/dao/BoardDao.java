package myspring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.model.Board;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession session;

	public int insert(Board board) {
		return session.insert("insert", board);
	}

	public int getCount() {
		return session.selectOne("count");
	}

	public List<Board> getBoardList(int page) {
		return session.selectList("list", page);
	}

	public void getUpdateCount(int no) {
		session.update("hit", no);
	}

	public Board getBoard(int no) {
		return session.selectOne("content", no);
	}

	public int getUpdate(Board board) {
		return session.update("update", board);
	}

	public int delete(int no) {
		return session.delete("delete", no);
	}
}
