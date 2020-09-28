package vo;

//������ ������ ������ �� �ִ� ActionForward Ŭ����.
public class ActionForward {

	private String path; // �������� ��û ó�� �� �������� ���� �� ������ url�� ����Ǵ� ���� ����.
	private boolean redirect; // ������ ����� ����Ǵ� ����. ���� false�� ����ġ �������, ���� true�� �����̷�Ʈ ������� ������.
	
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