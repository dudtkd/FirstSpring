package kr.or.ddit.vo;

import lombok.Data;

@Data
public class FreeVO {

	private int freeNo;			// 공지 게시판 번호
	private String freeTitle;		// 공지 게시판 제목
	private String freeWriter;	// 공지 게시판 작성자
	private String freeContent;	// 공지 게시판 내용
	private String freeDate;		// 공지 게시판 작성일
	private int freeHit;			// 공지 게시판 조회수
}
