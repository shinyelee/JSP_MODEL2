package vo;

//������ ������ ������ �� �ִ� ActionForward Ŭ����.
public class ActionForward {

	private boolean redirect; // ������ ����� ����Ǵ� ����. ���� false�� ����ġ �������, ���� true�� �����̷�Ʈ ������� ������.
	private String path; // �������� ��û ó�� �� �������� ���� �� ������ url�� ����Ǵ� ���� ����.
	
	// alt+shift+s -> r(Generate Getters and Setters) -> Select All -> OK.
	public boolean isRedirect() {
		return redirect;
	}
	
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}