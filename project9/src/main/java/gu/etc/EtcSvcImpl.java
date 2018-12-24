package gu.etc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gu.board.BoardSearchVO;

@Repository
public class EtcSvcImpl implements EtcSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Integer selectAlertCount(String param) {
		return sqlSession.selectOne("selectAlertCount", param);
	}

	@Override
	public List<?> selectAlertList4Ajax(String param) {
		return sqlSession.selectList("selectAlertList4Ajax", param);
	}

	@Override
	public List<?> selectAlertList(String param) {
		return sqlSession.selectList("selectAlertList", param);
	}

	@Override
	public Integer selectList4UserCount(BoardSearchVO param) {
		return sqlSession.selectOne("selectList4UserCount", param);
	}

	@Override
	public List<?> selectList4User(BoardSearchVO param) {		
		return sqlSession.selectList("selectList4User", param);
	}	
	
}
