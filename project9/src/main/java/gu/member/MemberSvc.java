package gu.member;

import java.util.List;

import gu.common.SearchVO;

public interface MemberSvc {

	public Integer selectSearchMemberCount(SearchVO param);
	
	public List<?> selectSearchMemberList(SearchVO param);
	
	public UserVO selectMember4Login(LoginVO param);
	
	public void insertLogIn(String param);
	
	public void insertLogOut(String param);
	
}
