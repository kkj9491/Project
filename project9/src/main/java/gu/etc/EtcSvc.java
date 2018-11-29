package gu.etc;

import java.util.List;

public interface EtcSvc {

	public Integer selectAlertCount(String param);
	
	public List<?> selectAlertList4Ajax(String param);
	
	public List<?> selectAlertList(String param);
	
	/*public Integer selectList4UserCount(BoardSearchVO param);
	
	public List<?> selectList4User(BoardSearchVO param);*/
	
}
