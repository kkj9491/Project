package gu.main;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IndexSvcImpl implements IndexSvc{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<?> selectRecentNews() {		
		return sqlSession.selectList("selectRecentNews");
	}

	@Override
	public List<?> selectTimeLine() {		 
		return sqlSession.selectList("selectTimeLine");
	}

	@Override
	public List<?> selectNoticeListTop5() {
		return sqlSession.selectList("selectNoticeListTop5");
	}

}
