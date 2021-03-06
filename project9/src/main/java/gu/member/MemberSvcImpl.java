package gu.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gu.common.SearchVO;

@Repository
public class MemberSvcImpl implements MemberSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Integer selectSearchMemberCount(SearchVO param) {
		return sqlSession.selectOne("selectSearchMemberCount", param);
	}

	@Override
	public List<?> selectSearchMemberList(SearchVO param) {
		return sqlSession.selectList("selectSearchMemberList", param);
	}

	@Override
	public UserVO selectMember4Login(LoginVO param) {
		return sqlSession.selectOne("selectMember4Login", param);
	}

	@Override
	public void insertLogIn(String param) {
		sqlSession.insert("insertLogin", param);		
	}

	@Override
	public void insertLogOut(String param) {
		sqlSession.insert("insertLogOut", param);
	}
	
	
}
