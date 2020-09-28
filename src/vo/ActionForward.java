package vo;

//포워딩 정보를 저장할 수 있는 ActionForward 클래스.
public class ActionForward {

	private String path; // 서블릿에서 요청 처리 후 포워딩될 최종 뷰 페이지 url이 저장되는 변수 정의.
	private boolean redirect; // 포워딩 방식이 저장되는 변수. 값이 false면 디스패치 방식으로, 값이 true면 리다이렉트 방식으로 포워딩.
	
	// alt+shift+s -> r(Generate Getters and Setters) -> Select All -> OK.
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isRedirect() {
		return redirect;
	}
	
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

}