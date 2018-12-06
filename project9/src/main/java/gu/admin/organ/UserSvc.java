package gu.admin.organ;

import java.util.List;

import gu.common.SearchVO;
import gu.member.UserVO;

public interface UserSvc {
	
	public List<?> selectUserList(String param);
	
	public List<?> selectUserListWithDept(SearchVO param);

	/*
	사용자 저장
	*/
	public void insertUser(UserVO param);
	
	public String selectUserID(String param);
	
	public UserVO selectUserOne(String param);
	
	public void deleteUser(String param);
	
	/*
	사용자
	*/
	public void updateUserByMe(UserVO param);
	
	public void updateUserPassword(UserVO param);
}
