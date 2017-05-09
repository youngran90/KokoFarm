package kokofarm.product.domain;

import java.util.List;

public class ListProductPage {
	 private List<ProductDTO> list;
	 private int requestPage; 
	 private int totalPageCount; 
	 private int startPage;
	 private int endPage;  
	 private String searchOption;
	 private String searchText;
	 
	 public ListProductPage(){}

	public ListProductPage(List<ProductDTO> list, int requestPage, int totalPageCount, int startPage, int endPage, String searchOption, String searchText) {
		super();
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.searchOption = searchOption;
		this.searchText= searchText;
	}

	public List<ProductDTO> getList() {
		return list;
	}

	public void setList(List<ProductDTO> list) {
		this.list = list;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	
	 
	 
}
