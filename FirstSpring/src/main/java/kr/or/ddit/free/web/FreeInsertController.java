package kr.or.ddit.free.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;

@Controller
@RequestMapping("/free")
public class FreeInsertController {

	@Inject
	private IFreeService freeService;

	@RequestMapping(value = "/form.do", method = RequestMethod.GET)
	public String freeForm() {
		return "free/form";
	}
	
	@RequestMapping(value = "/insert.do",method = RequestMethod.POST)
	public String freeInsert(FreeVO freeVO, Model model) {
		String goPage = "";
		
		Map<String,String> errors = new HashMap<String, String>();
		if(StringUtils.isBlank(freeVO.getFreeTitle())) {
			errors.put("freeTitle", "제목을 입력해주세요");
		}
		if(StringUtils.isBlank(freeVO.getFreeContent())) {
			errors.put("freeContent","내용을 입력해주세요");
		}
		
		if(errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("free", freeVO);
			goPage = "free/form";
		}else {
			freeVO.setFreeWriter("freeman");
			ServiceResult result = freeService.insertFree(freeVO);
			if(result.equals(ServiceResult.OK)) {
				goPage = "redirect:/free/detail.do?freeNo="+freeVO.getFreeNo();
			}else {
				model.addAttribute("free",freeVO);
				goPage = "free/form";
			}
		}
		
		return goPage;
	}
	
	
	
}
