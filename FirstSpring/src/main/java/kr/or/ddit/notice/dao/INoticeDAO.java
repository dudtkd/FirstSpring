package kr.or.ddit.notice.dao;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeDAO {

	int insertNotice(NoticeVO noticeVO);

	int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	List<NoticeVO> selectNoiceList(PaginationInfoVO<NoticeVO> pagingVO);

	void incrementHit(int noticeNo);

	NoticeVO selectNotice(int noticeNo);

	int updateNotice(NoticeVO noticeVO);

	int deleteNotice(int noticeNo);

}
