package gu.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.board.BoardSearchVO;
import gu.board.BoardSvc;
import gu.common.Utile4calen;
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
	@RequestMapping(value = "/sample2")
	public String sample2(HttpServletRequest request, ModelMap modelMap) {
		String userno = request.getSession().getAttribute("userno").toString();
		
		Integer alertcount = etcSvc.selectAlertCount(userno);
		modelMap.addAttribute("alertcount", alertcount);
		//------------------------
		
		String today = Utile4calen.date2Str(Utile4calen.getToday());
		
		modelMap.addAttribute("today", today);
		return "main/sample2";
	}
	
	/*차트 사용 샘플*/
	@RequestMapping(value ="/sample3")
	public String sample3(HttpServletRequest request, ModelMap modelMap) {
		String userno = request.getSession().getAttribute("userno").toString();
		
		Integer alertcount = etcSvc.selectAlertCount(userno);
		modelMap.addAttribute("alertcount", alertcount);
		//------------------------------------
		
		List<?> listview = sampleSvc.selectBoardGroupCount4Statistic();
		modelMap.addAttribute("listview", listview);
		
		return "main/sample3";
	}
	
	/*List & Excel 사용샘플*/
	@RequestMapping(value = "/sample4")
	public String sample4(HttpServletRequest request, BoardSearchVO searchVO, ModelMap modelMap) {
		String userno = request.getSession().getAttribute("userno").toString();
		
		Integer alertcount = etcSvc.selectAlertCount(userno);
		modelMap.addAttribute("alertcount", alertcount);
		//---------------------------------
		
		
		
	}
	
	
}
