package gu.crud;

import java.util.List;

import gu.common.SearchVO;

public interface CrudSvc {

	
	// 리스트
	public Integer selectCrudCount(SearchVO param);
	
	public List<?> selectCrudList(SearchVO param);
	
	
	// 저장
	public void insertCrud(CrudVO param);
	
	
	// 읽기
	public CrudVO selectCrudOne(CrudVO param);
	
	
	// 삭제
	public void deleteCrud(CrudVO param);
	
	
	// 저장
	public void deleteChk(String[] param);

	
	
}
