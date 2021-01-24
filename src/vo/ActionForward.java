package vo;

// ��Ʈ�ѷ� ������ �ϴ� �������� Ŭ���̾�Ʈ�� �� ��û�� �޾Ƽ� ó���� �� ���������� �� �������� ������ ó�� ��
// �̵��� �� �������� url�� ������ ���(Dispatch �Ǵ� Redirect)�� �ʿ���.
// �� �� ������ ���ϰ� �ٷ�� ���� ����� Ŭ������ -> ������ ������ ������ �� �ִ� ActionForward Ŭ����.
public class ActionForward {

	// �������� ��û ó�� �� �������� ���� �� ������ url�� ����Ǵ� ���� ����.
	private String path;
	// ������ ����� ����Ǵ� ���� -> ���� false�� ����ó �������, ���� true�� �����̷�Ʈ ������� ������.
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