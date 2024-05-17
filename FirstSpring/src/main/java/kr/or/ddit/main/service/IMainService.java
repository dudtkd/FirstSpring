package kr.or.ddit.main.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;

public interface IMainService {

	List<BoardVO> selectBoardList();

	List<NoticeVO> selectNoticeList();

	List<FreeVO> selectFreeList();

	Map<String, Object> count();

}
