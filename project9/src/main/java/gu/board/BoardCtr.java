package gu.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import gu.admin.board.BoardGroupSvc;
import gu.admin.board.BoardGroupVO;
import gu.common.Field3VO;
import gu.etc.EtcSvc;

@Controller
public class BoardCtr {

	
	@Autowired
	private BoardSvc boardSvc;
	
	@Autowired
	private BoardGroupSvc boardGroupSvc;
	
	@Autowired
	private EtcSvc etcSvc;
	
	static final Logger LOGGER = LoggerFactory.getLogger(BoardCtr.class);
	
	
	//리스트
	@RequestMapping(value = "/boardList")
	public String boardList(HttpServletRequest request, BoardSearchVO searchVO, ModelMap modelMap) {
		String globalKeyword = request.getParameter("globalKeyword");
		if(globalKeyword!=null & !"".equals(globalKeyword)) {
			searchVO.setSearchKeyword(globalKeyword);
		}
		
		String userno = request.getSession().getAttribute("userno").toString();
		
		Integer alertcount = etcSvc.selectAlertCount(userno);
		modelMap.addAttribute("alertcount", alertcount);
		
		if(searchVO.getBgno() != null && !"".equals(searchVO.getBgno())) {
			BoardGroupVO bgInfo = boardSvc.selectBoardGroupOne4Used(searchVO.getBgno());
			if(bgInfo == null) {
				return "board/BoardGroupFail";				
			}
			modelMap.addAttribute("bgInfo", bgInfo);
		}
		
		List<?> noticelist = boardSvc.selectNoticeList(searchVO);
		
		searchVO.pageCalculate(boardSvc.selectBoardCount(searchVO));  // startrow, endrow
		List<?> listview = boardSvc.selectBoardList(searchVO)
;
		modelMap.addAttribute("searchVO", searchVO);
		modelMap.addAttribute("listview", listview);
		modelMap.addAttribute("noticelist", noticelist);
		
		if(searchVO.getBgno() == null || "".equals(searchVO.getBgno())) {
			return "board/BoardListAll";
		}
		
		return "board/BoardList";
	}
	
	
	//글쓰기
	@RequestMapping(value = "/boardForm")
	public String boardForm(HttpServletRequest request, ModelMap modelMap) {
		String userno = request.getSession().getAttribute("userno").toString();
		
		Integer alertcount = etcSvc.selectAlertCount(userno);
		modelMap.addAttribute("alertcount", alertcount);
		
		String bgno = request.getParameter("bgno");
		String brdno = request.getParameter("brdno");
		
		if(brdno != null) {
			BoardVO boardInfo = boardSvc.selectBoardOne(new Field3VO(brdno, null, null));
			List<?> listview = boardSvc.selectBoardFileList(brdno);
			
			modelMap.addAttribute("boardInfo", boardInfo);
			modelMap.addAttribute("listview", listview);
			bgno = boardInfo.getBgno();			
		}
		BoardGroupVO bgInfo = boardSvc.selectBoardGroupOne4Used(bgno);
		if(bgInfo == null) {
			return "board/BoardGroupFail";			
		}
		
		modelMap.addAttribute("bgno", bgno);
		modelMap.addAttribute("bgInfo", bgInfo);
		
		return "board/BoardForm";
	}
	
	
	//글 저장
	@RequestMapping(value = "/boardSave")
	public String boardSave(HttpServletRequest request, BoardVO boardInfo) {
		String userno = request.getSession().getAttribute("userno").toString();
		boardInfo.setUserno(userno);
		
		if(boardInfo.getBrdno() != null && !"".equals(boardInfo.getBrdno())) {   // check auth for update
			String chk = boardSvc.selectBoardAuthChk(boardInfo);
			if(chk == null) {
				return "common/noAuth";
			}
		}
		
		
		
		return null;
	}
	
}
