package kr.or.ddit.vo;

import lombok.Data;

@Data
public class NoticeVO {

		private int noticeNo;			// 공지 게시판 번호
		private String noticeTitle;		// 공지 게시판 제목
		private String noticeWriter;	// 공지 게시판 작성자
		private String noticeContent;	// 공지 게시판 내용
		private String noticeDate;		// 공지 게시판 작성일
		private int noticeHit;			// 공지 게시판 조회수

		
		
	

}
