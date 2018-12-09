package gu.admin.organ;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartSvcImpl {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
}
