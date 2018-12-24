package gu.etc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlertMsgCtr {

	@Autowired
	private EtcSvc etcSvc;
	
	
	//alert리스트 전체.
	@RequestMapping(value = "/alertList")
	public String alertList(HttpServletRequest request, ModelMap modelMap) {
		String userno = request.getSession().getAttribute("userno").toString();
		
		
		return null;
	}
}
