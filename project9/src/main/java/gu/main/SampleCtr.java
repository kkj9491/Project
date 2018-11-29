package gu.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.board.BoardSvc;
import gu.etc.EtcSvc;

@Controller
public class SampleCtr {

	@Autowired
	private SampleSvc sampleSvc;
	
	@Autowired
	private EtcSvc etcSvc;
	
	@Autowired
	private BoardSvc boardSvc;
	
	/* 조직도/사용자 선택 샘플 */
	@RequestMapping(value = "/sample1")
	public String sample1(HttpServletRequest request, ModelMap modelMap) {
		String userno = request.getSession().getAttribute("userno").toString();
		
		Integer alertcount = etcSvc.selectAlertCount(userno);
		modelMap.addAttribute("alertcount", alertcount);
		
		return "main/sample1";
	}
	
	/*날짜 선택 샘풀*/
		
	
}
