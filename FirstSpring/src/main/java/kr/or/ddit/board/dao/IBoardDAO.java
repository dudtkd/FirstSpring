package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardDAO {

	public List<BoardVO> selectBoardList();

	public int insertBoard(BoardVO boardVO);

	public BoardVO selectBoard(int boNo);
	// 상세정보를 조회하기 위해서는 selectBoard, incrementHit(조회수) 두가지가 필요
	public void incrementHit(int boNo);

	public int updateBoard(BoardVO boardVO);

	public int deleteBoard(int boNo);

	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);

	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);

}
