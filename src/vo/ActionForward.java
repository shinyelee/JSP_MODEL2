package vo;
public class ActionForward { // ������ ������ ������ �� �ִ� ActionForward Ŭ����.

	private String path; // �������� ��û ó�� �� �������� ���� �� ������ url�� ����Ǵ� ���� ����.
	private boolean redirect; // ������ ����� ����Ǵ� ����. ���� false�� ����ġ �������, ���� true�� �����̷�Ʈ ������� ������.
	// alt+shift+s -> r(Generate Getters and Setters) -> (Select All) -> OK.
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

}
