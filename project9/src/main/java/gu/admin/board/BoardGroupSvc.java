package gu.admin.board;

import java.util.List;

public interface BoardGroupSvc {

	public List<?> selectBoardGroupList();
	
	//게시판 저장
	public void insertBoard(BoardGroupVO param);
	
		
	public BoardGroupVO selectBoardGroupOne(String param);
	
	public void deleteBoardGroup(String param);
	
}
