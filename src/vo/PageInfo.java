package vo;

public class PageInfo { // 페이징 처리 관련 정보를 저장하는 클래스.
	
	private int page; // 페이지(번호).
	private int maxPage; // 총 페이지.
	private int startPage; // 시작 페이지.
	private int endPage; // 마지막 페이지.
	private int listCount; // 총 글의 개수.
	// alt+shift+s -> r(Generate Getters and Setters) -> (Select All) -> OK.
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getMaxPage() {
		return maxPage;
	}
	
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
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
	
	public int getListCount() {
		return listCount;
	}
	
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

}
