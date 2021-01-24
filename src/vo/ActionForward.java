package vo;

// 컨트롤러 역할을 하는 서블릿에서 클라이언트의 각 요청을 받아서 처리한 후 최종적으로 뷰 페이지로 포워딩 처리 시
// 이동할 뷰 페이지의 url과 포워딩 방식(Dispatch 또는 Redirect)이 필요함.
// 이 두 정보를 편리하게 다루기 위해 설계된 클래스가 -> 포워딩 정보를 저장할 수 있는 ActionForward 클래스.
public class ActionForward {

	// 서블릿에서 요청 처리 후 포워딩될 최종 뷰 페이지 url이 저장되는 변수 정의.
	private String path;
	// 포워딩 방식이 저장되는 변수 -> 값이 false면 디스패처 방식으로, 값이 true면 리다이렉트 방식으로 포워딩.
	private boolean redirect;
	
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
	
	public ActionForward() {
	}

}