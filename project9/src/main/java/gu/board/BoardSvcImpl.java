package gu.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import gu.admin.board.BoardGroupVO;
import gu.common.Field3VO;
import gu.common.FileVO;

public class BoardSvcImpl implements BoardSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private DataSourceTransactionManager txManager;
	
	static final Logger LOGGER = LoggerFactory.getLogger(BoardSvc.class);
	
	//게시판 정보(그룹)
	@Override
	public BoardGroupVO selectBoardGroupOne4Used(String param) {
		return sqlSession.selectOne("selectBoardGroupOne4Used", param);
	}

	
	//게시판
	@Override
	public Integer selectBoardCount(BoardSearchVO param) {
		return sqlSession.selectOne("selectBoardCount", param);
	}

	@Override
	public List<?> selectBoardList(BoardSearchVO param) {
		return sqlSession.selectList("selectBoardList", param);
	}

	@Override
	public List<?> selectNoticeList(BoardSearchVO param) {
		return sqlSession.selectList("selectNoticeList", param);
	}

	
	// 글 저장
	@Override
	public void insertBoard(BoardVO param, List<FileVO> filelist, String[] fileno) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		
	}

	@Override
	public BoardVO selectBoardOne(Field3VO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectBoardAuthChk(BoardVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoardRead(Field3VO param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardOne(String param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBoardLike(Field3VO param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> selectBoardFileList(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> selectBoardReplyList(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardReplyVO insertBoardReply(BoardReplyVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectBoardReplyAuthChk(BoardReplyVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBoardReply(String param) {
		// TODO Auto-generated method stub
		return false;
	}	
	
}
