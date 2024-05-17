package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeService {

	ServiceResult insertNotice(NoticeVO noticeVO);

	int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	NoticeVO selectNotice(int noticeNo);

	ServiceResult updateNotice(NoticeVO noticeVO);

	ServiceResult deleteNotice(int noticeNo);

}
