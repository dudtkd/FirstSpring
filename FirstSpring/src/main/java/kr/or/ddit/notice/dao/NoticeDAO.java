package kr.or.ddit.notice.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Repository
public class NoticeDAO implements INoticeDAO {

	
	@Inject	// SqlSessionTemplate를 사용하기 위해 의존성 주입
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertNotice(NoticeVO noticeVO) {
		return sqlSession.insert("Notice.insertNotice", noticeVO);
	}

	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return sqlSession.selectOne("Notice.selectNoticeCount", pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoiceList(PaginationInfoVO<NoticeVO> pagingVO) {
		System.out.print("selectList"+sqlSession.selectList("Notice.selectNoticeList",pagingVO));
		return sqlSession.selectList("Notice.selectNoticeList",pagingVO);
		
	}

	@Override
	public void incrementHit(int noticeNo) {
		sqlSession.update("Notice.incrementHit",noticeNo);
	}

	@Override
	public NoticeVO selectNotice(int noticeNo) {
		return sqlSession.selectOne("Notice.selectNotice", noticeNo);
	}

	@Override
	public int updateNotice(NoticeVO noticeVO) {
		return sqlSession.update("Notice.updateNotice", noticeVO);
	}

	@Override
	public int deleteNotice(int noticeNo) {
		return sqlSession.delete("Notice.deleteNotice", noticeNo);
	}

}
