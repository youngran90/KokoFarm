package kokofarm.member.domain;

public class ListModel {
	private String requestPage;
	private String totalPageNum;
	private String startPage;
	private String endPage;
	
	public ListModel() {
		
	}

	public String getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(String requestPage) {
		this.requestPage = requestPage;
	}

	public String getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(String totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public String getStartPage() {
		return startPage;
	}

	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}

	public String getEndPage() {
		return endPage;
	}

	public void setEndPage(String endPage) {
		this.endPage = endPage;
	}
	

}
