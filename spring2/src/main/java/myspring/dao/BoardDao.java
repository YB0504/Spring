package myspring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myspring.model.Board;

// @Repository
@Mapper
public interface BoardDao {

	public int insert(Board board);

	public int getCount();

	public List<Board> getBoardList(int page);

	public void getUpdateCount(int no);

	public Board getBoard(int no);

	public int getUpdate(Board board);

	public int delete(int no);
}
