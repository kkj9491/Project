package gu.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.admin.organ.UserSvc;
import gu.common.FileUtil;

@Controller
public class MemberCtr {

	@Autowired
	private UserSvc userSvc;
	
	@Autowired
	private MemberSvc memberSvc;
	
	//내정보
	@RequestMapping(value="/memberForm")
	public String memberForm(HttpServletRequest request, ModelMap modelMap) {
		String save = request.getParameter("save");
		
		String userno = request.getSession().getAttribute("userno").toString();
		
		UserVO userInfo = userSvc.selectUserOne(userno);
		
		modelMap.addAttribute("userInfo", userInfo);
		modelMap.addAttribute("save", save);
		
		return "member/memberForm";
	}
	
	//사용자 저장
	@RequestMapping(value="/userSave")
	public String userSave(HttpServletRequest request, ModelMap modelMap, UserVO userInfo) {
		String userno = request.getSession().getAttribute("userno").toString();
		userInfo.setUserno(userno);
		
		FileUtil fs = new FileUtil();
		
		
		
		return null;
	}
	
}
