// �����ͺ��̽��� �α��� ���� SQL ������ ����
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.Member;
import static db.JdbcUtil.*;

public class LoginDAO {
	
	// LoginDAO Ÿ���� ���۷��� ���� ����.
	// ���� �����ڸ� private���� ������ �ܺ� Ŭ�������� ���� ������ �� ���� ��.
	private static LoginDAO loginDAO;
	// LoginDAO Ŭ�������� DB �۾��� �� �� ����� Connection ��ü�� ���� ����.
	private Connection con;
	
	// ���� �����ڸ� private���� ������
	// �ܺ� Ŭ�������� LoginDAO�� �����ڸ� ����� LoginDAO ��ü�� ���� ������ �� ���� �ߴ�.
	private LoginDAO() {

	}
	
	// �ܺ� Ŭ�������� getInstance �޼ҵ带 ó�� ȣ���� ��(loginDAO��=null)�� LoginDAO ��ü�� �����ϰ�
	// �� ��° ȣ���� �����ʹ� ��ü�� �ݺ������� �������� �ʰ� ó�� ȣ�� �� ������ ��ü�� ���۷��� ���� ��ȯ�ϰ� ����.
	// �� ���ó�� ��ü�� �� ������ �ϳ� ������ �� �����ϴ� ������ singleton �����̶�� ��.
	// �ַ� Ŭ������ �޼ҵ常 ���ǵǾ� �ְ� ��ü���� �ٸ� �Ӽ� ���� ������ �ʿ䰡 ���� Ŭ������ ����.
	public static LoginDAO getInstance() {
		if(loginDAO == null) {
		   loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	
	// LoginDAO ��ü���� ����� Connection ��ü�� ����.
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// ����ڰ� �Է��� ���̵�� ��й�ȣ�� ����� �α��� ó���� ������ ��
	// �α��ο� �����ϸ� ������� ������ Member ��ü�� ������ ��ȯ�ϰ�,
	// �α��ο� �����ϸ� null�� ��ȯ�ϴ� �޼ҵ� ����.
	public Member selectLoginMember(String id, String passwd) {
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// ����ڰ� �Է��� ���̵�� ��й�ȣ�� ���� ȸ���� ��� �÷� ���� �������� SQL ���� ����.
			pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ? AND passwd = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// ������ ��ȸ�� ȸ�������� Member ��ü�� �Ӽ� ������ ����.
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