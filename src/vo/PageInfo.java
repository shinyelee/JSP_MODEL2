package vo;

public class PageInfo { // ����¡ ó�� ���� ������ �����ϴ� Ŭ����.
	
	private int page; // ������(��ȣ).
	private int maxPage; // �� ������.
	private int startPage; // ���� ������.
	private int endPage; // ������ ������.
	private int listCount; // �� ���� ����.
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
