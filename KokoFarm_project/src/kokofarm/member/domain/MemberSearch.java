package kokofarm.member.domain;

import java.io.Serializable;

public class MemberSearch implements Serializable{
	
	private String[] area;
	private String searchKey;
	
	public String[] getArea() {
		return area;
	}
	public void setArea(String[] area) {
		this.area = area;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}


}
