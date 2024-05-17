package kr.or.ddit.notice.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {

	// 의존성 주입 및 싱글톤 객체처럼 사용가능
	@Inject
	private INoticeService noticeService;
	
	// 공지 게시판 등록 폼 요청
	@RequestMapping(value = "/form.do", method = RequestMethod.GET)
	public String noticeForm() {
		// appServlet안에 servlet-context.xml에서 경로를 WEB-INF/views/ 까지 잡아놓았기때문에 앞에 /를 빼고 작성한다.
		return "notice/form";
	}
	
	@RequestMapping(value = "insert.do",method = RequestMethod.POST)
	public String noticeInsert(NoticeVO noticeVO, Model model) {
		String goPage = ""; // 데이터를 가용하는 부분에서 로직상 페이지 정보를 담을 공간
		
		Map<String, String> errors = new HashMap<String,String>();
		if(StringUtils.isBlank(noticeVO.getNoticeTitle())) {
			errors.put("noticeTitle","공지사항을 입력해주세요");
		}
		if(StringUtils.isBlank(noticeVO.getNoticeContent())) {
			errors.put("noticeContent","내용을 입력해 주세요");
		}
		
		if(errors.size() > 0) {	// errors 사이즈가 0보다 크면 에러가 발생한것
			model.addAttribute("errors", errors);
			model.addAttribute("notice", noticeVO);
			goPage = "notice/form";
		}else {	// 정상적인 데이터로 들어왔을때
			noticeVO.setNoticeWriter("관리자");	// 임시로 하드코딩해놓는다.
			ServiceResult result = noticeService.insertNotice(noticeVO);
			if(result.equals(ServiceResult.OK)) {	// ok면 등록 성공
				// 등록에 성공했을때 디테일 페이지로 이동시킨다.
				goPage = "redirect:/notice/detail.do?noticeNo="+noticeVO.getNoticeNo();
			}else {	// 등록 실패
				model.addAttribute("notice", noticeVO);
				goPage = "notice/form";
						
			}
		}
		
		return goPage;
		
	}
}
