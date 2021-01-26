// 데이터베이스에 로그인 관련 SQL 구문을 전송
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.Member;
import static db.JdbcUtil.*;

public class LoginDAO {
	
	// LoginDAO 타입의 레퍼런스 변수 선언.
	// 접근 제한자를 private으로 지정해 외부 클래스에서 직접 접근할 수 없게 함.
	private static LoginDAO loginDAO;
	// LoginDAO 클래스에서 DB 작업을 할 때 사용할 Connection 객체의 변수 선언.
	private Connection con;
	
	// 접근 제한자를 private으로 지정해
	// 외부 클래스에서 LoginDAO의 생성자를 사용해 LoginDAO 객체를 직접 생성할 수 없게 했다.
	private LoginDAO() {

	}
	
	// 외부 클래스에서 getInstance 메소드를 처음 호출할 때(loginDAO값=null)만 LoginDAO 객체를 생성하고
	// 두 번째 호출할 때부터는 객체를 반복적으로 생성하지 않고 처음 호출 때 생성된 객체의 레퍼런스 값을 반환하게 정의.
	// 이 경우처럼 객체를 힙 영역에 하나 생성한 후 공유하는 패턴을 singleton 패턴이라고 함.
	// 주로 클래스에 메소드만 정의되어 있고 객체마다 다른 속성 값을 유지할 필요가 없는 클래스에 사용됨.
	public static LoginDAO getInstance() {
		if(loginDAO == null) {
		   loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	
	// LoginDAO 객체에서 사용할 Connection 객체를 주입.
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// 사용자가 입력한 아이디와 비밀번호를 사용해 로그인 처리를 수행한 후
	// 로그인에 성공하면 사용자의 정보를 Member 객체에 저장해 반환하고,
	// 로그인에 실패하면 null을 반환하는 메소드 정의.
	public Member selectLoginMember(String id, String passwd) {
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 사용자가 입력한 아이디와 비밀번호를 가진 회원의 모든 컬럼 값을 가져오는 SQL 구문 실행.
			pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ? AND passwd = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 위에서 조회한 회원정보를 Member 객체의 속성 값으로 설정.
				loginMember = new Member();
				loginMember.setAddr(rs.getString("addr"));
				loginMember.setAge(rs.getInt("age"));
				loginMember.setEmail(rs.getString("email"));
				loginMember.setGender(rs.getString("gender"));
				loginMember.setId(rs.getString("id"));
				loginMember.setName(rs.getString("name"));
				loginMember.setNation(rs.getString("nation"));
				loginMember.setPasswd(rs.getString("passwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
}