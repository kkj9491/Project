package gu.admin.organ;

import java.util.List;

public interface DepartSvc {

	public List<?> selectDepartment();
	
	// 부서저장
	public void insertDepartment(DepartmentVO param);
	
	
	public DepartmentVO selectDepartmentOne(String param);
	
	public void deleteDepartment(String param);
	
}
