package gu.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import gu.common.SearchVO;

@Repository
public class MemberSvcImpl implements MemberSvc {

	@Override
	public Integer selectSearchMemberCount(SearchVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> selectSearchMemberList(SearchVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO selectMember4Login(LoginVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLogIn(String param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLogOut(String param) {
		// TODO Auto-generated method stub
		
	}
	
	
}
