package gu.admin.organ;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartSvcImpl implements DepartSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	@Override
	public List<?> selectDepartment() {
		return sqlSession.selectList("selectDepartment");
	}

	
	//부서저장 부분
	@Override
	public void insertDepartment(DepartmentVO param) {
		if("".equals(param.getParentno())) {
			param.setParentno(null);
		}
		
		if(param.getDeptno() == null || "".equals(param.getDeptno())) {
			sqlSession.insert("insertDepartment", param);
		} else {
			sqlSession.insert("updateDepartment", param);
		}		
	}

	
	@Override
	public DepartmentVO selectDepartmentOne(String param) {		
		return sqlSession.selectOne("selectDepartmentOne", param);
	}

	@Override
	public void deleteDepartment(String param) {
		sqlSession.delete("deleteDepartment", param);		
	}
	
}
