package gu.board;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
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
		
		try {
			if(param.getBrdno() ==null || "".equals(param.getBrdno())) {
				sqlSession.insert("insertBoard", param);				
			} else {
				sqlSession.update("insertBoard", param);				
			}
			
			if(fileno != null) {
				HashMap<String, String[]> fparam = new HashMap<String, String[]>(); 
			}
			
			for(FileVO f : filelist) {
				f.setParentPK(param.getBrdno());
				sqlSession.insert("insertBoardFile", f);				
			}
			txManager.commit(status);
		} catch(TransactionException ex) {
			txManager.rollback(status);
			LOGGER.error("insertBoard");			
		}		
	}

	@Override
	public BoardVO selectBoardOne(Field3VO param) {		
		return sqlSession.selectOne("selectBoardOne", param);
	}
	
	
	// 게시판  수정 / 삭제 권한 확인
	@Override
	public String selectBoardAuthChk(BoardVO param) {
		return sqlSession.selectOne("selectBoardAuthChk", param);
	}

	@Override
	public void updateBoardRead(Field3VO param) {
		sqlSession.insert("updateBoardRead", param);		
	}

	@Override
	public void deleteBoardOne(String param) {
		sqlSession.delete("deleteBoardOne",param);		
	}

	
	//좋아요 저장
	@Override
	public void insertBoardLike(Field3VO param) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		try {
			sqlSession.insert("insertBoardLike", param);
			sqlSession.update("updateBoard4Like", param);
			
			txManager.commit(status);
		} catch(TransactionException ex) {
			txManager.rollback(status);
			LOGGER.error("insertBoardLike");
		}		
	}

	@Override
	public List<?> selectBoardFileList(String param) {
		return sqlSession.selectList("selectBoardFileList", param);
	}
	
	
	//================================================
	@Override
	public List<?> selectBoardReplyList(String param) {
		return sqlSession.selectList("selectBoardFileList", param);
	}

	
	// 댓글 저장
	@Override
	public BoardReplyVO insertBoardReply(BoardReplyVO param) {
		if(param.getReno() == null || "".equals(param.getReno())) {
			if(param.getReparent() != null) {
				BoardReplyVO replyInfo = sqlSession.selectOne("selectBoardReplyParent", param.getReparent());
				param.setRedepth(replyInfo.getRedepth());
				param.setReorder(replyInfo.getReorder() + 1);
				sqlSession.selectOne("updateBoardReplyOrder", replyInfo);
			} else {
				Integer reorder = sqlSession.selectOne("selectBoardReplyMaxOrder", param.getBrdno());
				param.setReorder(reorder);
			}
			
			sqlSession.insert("insertBoardReply", param);
		} else {
			sqlSession.insert("updateBoardReply", param);
		}
		return sqlSession.selectOne("selectBoardReplyOne", param.getReno());
	}
	
	
	// 댓글 수정/삭제 권한 확인
	@Override
	public String selectBoardReplyAuthChk(BoardReplyVO param) {
		return sqlSession.selectOne("selectBoardReplyAuthChk", param);
	}

	
	//댓글 삭제, 자식댓글이있으면 삭제 불가
	@Override
	public boolean deleteBoardReply(String param) {
		Integer cnt = sqlSession.selectOne("selectBoardReplyChild", param);
		
		if (cnt >0) {
			return false;
		}
		
		sqlSession.update("updateBoardReplyOrder4Delete", param);
		
		sqlSession.delete("deleteBoardReply", param);
		
		return true;
	}	
	
}
