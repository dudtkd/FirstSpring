package kr.or.ddit.board.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/board")
public class BoardRetrieveController {

	@Inject
	private IBoardService boardService;
	
	@RequestMapping(value="/list.do")
	public String boardList(
			@RequestParam(name="page",required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model) {
		// [방법1] 일반적인 목록 조회
//		List<BoardVO> boardList = boardService.selectBoardList();
//		model.addAttribute("boardList", boardList);
		// [방법1] 일반적인 목록 조회 끝
		
		// [방법2] 페이징 및 검색이 적용된 목록 조회
		PaginationInfoVO<BoardVO> pagingVO = new PaginationInfoVO<BoardVO>();
		
		// 브라우저에서 검색한 검색 유형, 검색 키워드를 이동하여 검색 처리
		// 검색 키워드가 있으면 검색을 한것이고, 키워드가 없으면 검색을 하지 않음
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = boardService.selectBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<BoardVO> dataList = boardService.selectBoardList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		// [방법2] 페이징 및 검색이 적용된 목록 조회 끝

		return "board/list";
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String boardDetail(int boNo, Model model) {
		BoardVO boardVO =boardService.selectBoard(boNo);
		model.addAttribute("board", boardVO);
		return "board/view";
	}
}
