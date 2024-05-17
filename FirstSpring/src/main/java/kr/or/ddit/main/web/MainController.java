package kr.or.ddit.main.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.main.service.IMainService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;

@Controller
public class MainController {

	@Inject
	private IMainService mainService;
	
	@RequestMapping(value= {"/","/main.do"}, method = RequestMethod.GET)
	public String main(Model model) {
		List<BoardVO> boardList = mainService.selectBoardList();
		model.addAttribute("boardList", boardList);
		
		List<NoticeVO> noticeList = mainService.selectNoticeList();
		model.addAttribute("noticeList", noticeList);
		
		List<FreeVO> freeList = mainService.selectFreeList();
		model.addAttribute("freeList", freeList);
		
		
		Map<String,Object> count = mainService.count();
		model.addAttribute("count", count);
		
		// 밑에 방식이 아니다
//		BigDecimal boardcount = (BigDecimal)count.get("BOARDCOUNT");
//		model.addAttribute("boardcount", boardcount);
//		
//		BigDecimal noticecount = (BigDecimal)count.get("NOTICECOUNT");
//		model.addAttribute("noticecount", noticecount);
//		
//		BigDecimal freecount = (BigDecimal)count.get("FREECOUNT");
//		model.addAttribute("freecount", freecount);
		
		return "main";
	}
	
	
	
	
	
	
	
}
