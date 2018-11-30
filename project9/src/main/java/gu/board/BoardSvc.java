package gu.board;

import java.util.List;

import gu.admin.board.BoardGroupVO;
import gu.common.Field3VO;
import gu.common.FileVO;

public interface BoardSvc {

	/*게시판 정보(그룹)*/
	public BoardGroupVO selectBoardGroupOne4Used(String param);
	
	
	/*게시판*/
	public Integer selectBoardCount(BoardSearchVO param);
	
	public List<?> selectBoardList(BoardSearchVO param);
	
	public List<?> selectNoticeList(BoardSearchVO param);
	
	
	/*글 저장*/
	public void insertBoard(BoardVO param, List<FileVO> filelist, String[] fileno);
	
	public BoardVO selectBoardOne(Field3VO param);
	
	
	/*게시판 수정/삭제 권한 확인*/
	public String selectBoardAuthChk(BoardVO param);
	
	public void updateBoardRead(Field3VO param);
	
	public void deleteBoardOne(String param);
	
	
	/*좋아요 저장*/
	public void insertBoardLike(Field3VO param);
	
	public List<?> selectBoardFileList(String param);
	
	public List<?> selectBoardReplyList(String param);
	
	
	/*댓글 저장*/
	public BoardReplyVO insertBoardReply(BoardReplyVO param);
	
	
	/*댓글 수정/삭제 권한 확인*/
	public String selectBoardReplyAuthChk(BoardReplyVO param);
	
	
	/*
	댓글 삭제.
	자식 댓글이 존재하면 삭제 안됨
	*/
	public boolean deleteBoardReply(String param);
	
}
