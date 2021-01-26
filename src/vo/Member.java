package vo;

// 회원 한 명의 정보를 저장
public class Member {
	// 회원 한 명의 정보를 저장할 속성들과
	// 해당 속성 값들을 조회하는 메소드(Getter)들과
	// 갱신하는 메소드(Setter)들이 정의돼 있다.
	
	private String id; // 아이디
	private String passwd; // 비밀번호
	private String addr; // 주소
	private String email; // 이메일
	private String gender; // 성별
	private String name; // 이름
	private String mobile; // 휴대전화
	
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
