package gu.board;

import gu.common.PageVO;

public class BoardSearchVO extends PageVO {

	private String bgno;
	private String searchKeyword = "";
	private String searchType = "";
	private String[] searchTypeArr;
	private String searchExt1 = "";
	
	public String getBgno() {
		return bgno;
	}
	
	public void setBgno(String bgno) {
		this.bgno = bgno;
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	public void setSearchKeyword(String searchKeyword) {		
		this.searchKeyword = searchKeyword;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
		
    public String[] getSearchTypeArr() {
        return searchType.split(",");
    }	
	
	public String getSearchExt1() {
		return searchExt1;
	}
	
	public void setSearchExt1(String searchExt1) {
		this.searchExt1 = searchExt1;
	}	
	
}
