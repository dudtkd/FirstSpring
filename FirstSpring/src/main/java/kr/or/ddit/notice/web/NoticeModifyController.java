package kr.or.ddit.notice.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeModifyController {

	@Inject
	private INoticeService noticeSerive;
	
	// 이부분 헷갈림
	@RequestMapping(value = "/update.do" , method = RequestMethod.GET)
	public String noticeUpdateView(int noticeNo, Model model) {
		NoticeVO noticeVO = noticeSerive.selectNotice(noticeNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status", "u");
		return "notice/form";
		
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String noticeUpdate(NoticeVO noticeVO, Model model) {
		String goPage = "";
		ServiceResult result = noticeSerive.updateNotice(noticeVO);
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/detail.do?noticeNo="+noticeVO.getNoticeNo();
		}else {
			model.addAttribute("noitce", noticeVO);
			model.addAttribute("status", "u");
			goPage = "redirect:/notice/form";
		}
		return goPage;
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String noticeDelete(int noticeNo) {
		String goPage = "";
		ServiceResult result = noticeSerive.deleteNotice(noticeNo);
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/list.do";
		}else {
			goPage = "redirect:/notice/detail.do?noticeNo="+noticeNo;
		}
		return goPage;
		
		
		
		
		
	}
	
	
	
	
	
}
