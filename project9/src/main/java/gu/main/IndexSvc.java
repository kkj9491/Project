package gu.main;

import java.util.List;

public interface IndexSvc {

	public List<?> selectRecentNews();
	
	public List<?> selectTimeLine();
	
	public List<?> selectNoticeListTop5();
}
