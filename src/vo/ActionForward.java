package vo;

//������ ������ ������ �� �ִ� ActionForward Ŭ����.
public class ActionForward {

	private boolean isRedirect=false; // ������ ����� ����Ǵ� ����. ���� false�� ����ġ �������, ���� true�� �����̷�Ʈ ������� ������.
	private String path=null; // �������� ��û ó�� �� �������� ���� �� ������ url�� ����Ǵ� ���� ����.
	
	// alt+shift+s -> r(Generate Getters and Setters) -> Select All -> OK.
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean b) {
		this.isRedirect = b;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String string) {
		this.path = string;
	}
}