package gu.etc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
}
