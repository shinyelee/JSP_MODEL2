package vo;

// ȸ�� �� ���� ������ ����
public class Member {
	// ȸ�� �� ���� ������ ������ �Ӽ����
	// �ش� �Ӽ� ������ ��ȸ�ϴ� �޼ҵ�(Getter)���
	// �����ϴ� �޼ҵ�(Setter)���� ���ǵ� �ִ�.
	
	private String id; // ���̵�
	private String passwd; // ��й�ȣ
	private String addr; // �ּ�
	private String email; // �̸���
	private String gender; // ����
	private String name; // �̸�
	private String mobile; // �޴���ȭ
	
	// alt+shift+s -> Generate Getters and Setters -> Select All -> OK
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
