package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.LoginDAO;
import vo.Member;

// 로그인 비즈니스 로직 처리
public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		// LoginDAO 클래스에 정의돼 있는 getInstance() 메소드를 호출해 LoginDAO 객체를 참조하는 레퍼런스 값을 얻어옴.
		// LoginDAO 클래스 객체는 getInstance() 메소드가 처음 호출할 때만 생성하고
		// 두 번째 호출할 때부터는 힙 영역에 이미 생성돼 있는 객체의 레퍼런스 값을 반환(=singleton 패턴 사용).
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = getConnection();
		// LoginDAO 객체에서 DB 작업을 할 때 사용할 Connection 객체를 주입.
		loginDAO.setConnection(con);
		// LoginDAO 객체로 로그인한 사용자의 정보를 Member 객체로 반환하는 메소드(selectLoginmember)를 호출.
		Member loginMember = loginDAO.selectLoginMember(id,passwd);
		// DB 작업을 끝낸 후 사용했던 Connection 객체를 닫아줌.
		close(con);
		// 로그인된 사용자의 정보 반환.
		return loginMember;
	}
	
}