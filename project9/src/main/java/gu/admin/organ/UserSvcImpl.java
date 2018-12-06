package gu.admin.organ;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gu.common.SearchVO;
import gu.member.UserVO;

@Repository
public class UserSvcImpl implements UserSvc{

	@Autowired
	private SqlSessionTemplate sqlSession;	
	
	@Override
	public List<?> selectUserList(String param) {
		return sqlSession.selectList("selectUserList", param);
	}

	@Override
	public List<?> selectUserListWithDept(SearchVO param) {		
		return sqlSession.selectList("selectUserListWithDept", param);
	}

	/*
	사용자 저장
	*/
	@Override
	public void insertUser(UserVO param) {
		if(param.getUserno() == null || "".equals(param.getUserno())) {
			sqlSession.insert("insertUser", param);
		} else {
			sqlSession.insert("updateUser", param);
		}
	}

	@Override
	public String selectUserID(String param) {
		return sqlSession.selectOne("selectUserID", param);
	}

	@Override
	public UserVO selectUserOne(String param) {
		return sqlSession.selectOne("selectUserOne", param);
	}

	@Override
	public void deleteUser(String param) {
		sqlSession.delete("deleteUser", param);
	}

	/*
	사용자
	*/
	@Override
	public void updateUserByMe(UserVO param) {
		sqlSession.delete("updateUserByMe", param);
	}

	@Override
	public void updateUserPassword(UserVO param) {
		sqlSession.delete("updateUserPassword", param);		
	}
	
}
