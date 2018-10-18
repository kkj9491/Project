package gu.admin.code;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import gu.common.SearchVO;

@Repository
public class CodeSvcImpl implements CodeSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;	
	@Autowired
	private DataSourceTransactionManager txManager;	
	
	static final Logger LOGGER = LoggerFactory.getLogger(CodeSvc.class);
	
	@Override
	public Integer selectCodeCount(SearchVO param) throws Exception {		
		return sqlSession.selectOne("selectCodeCount", param);
	}

	@Override
	public List<?> selectCodeList(SearchVO param) throws Exception {
		return sqlSession.selectList("selectCodeList", param);
	}

	@Override
	public void insertCode(String codeFormType, CodeVO param) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();		
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		try {
			if("U".equals(codeFormType)) {
				sqlSession.update("updateCode", param);
			} else {
				sqlSession.insert("insertCode", param);
			}			
		} catch (TransactionException ex) {
			txManager.rollback(status);
			LOGGER.error("insertCode");			
		}		
	}

	@Override
	public CodeVO selectCodeOne(CodeVO param) throws Exception {		
		return sqlSession.selectOne("selectCodeOne", param);
	}

	@Override
	public void deleteCodeOne(CodeVO param) throws Exception {
		sqlSession.delete("deleteCodeOne", param);
		
	}

}
