package gu.admin.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.etc.EtcSvc;

@Controller
public class BoardGroupCtr {

	@Autowired
	private BoardGroupSvc boardSvc;
	
	@Autowired
	private EtcSvc etcSvc;
	
	
	//리스트
	@RequestMapping(value = "/adBoardGroupList")
	public String boardGroupList(HttpServletRequest request, ModelMap modelMap) {
		
		
		return null;
	}
	
}
