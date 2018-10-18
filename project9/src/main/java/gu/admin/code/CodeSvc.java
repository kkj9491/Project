package gu.admin.code;

import java.util.List;

import gu.common.SearchVO;

public interface CodeSvc {
	
	public Integer selectCodeCount(SearchVO param) throws Exception;
	
	public List<?> selectCodeList(SearchVO param) throws Exception;
	
	public void insertCode(String codeFormType, CodeVO param) throws Exception;
	
	public CodeVO selectCodeOne(CodeVO param) throws Exception;
	
	public void deleteCodeOne(CodeVO param) throws Exception;
}
