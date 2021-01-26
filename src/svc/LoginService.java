package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.LoginDAO;
import vo.Member;

// �α��� ����Ͻ� ���� ó��
public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		// LoginDAO Ŭ������ ���ǵ� �ִ� getInstance() �޼ҵ带 ȣ���� LoginDAO ��ü�� �����ϴ� ���۷��� ���� ����.
		// LoginDAO Ŭ���� ��ü�� getInstance() �޼ҵ尡 ó�� ȣ���� ���� �����ϰ�
		// �� ��° ȣ���� �����ʹ� �� ������ �̹� ������ �ִ� ��ü�� ���۷��� ���� ��ȯ(=singleton ���� ���).
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = getConnection();
		// LoginDAO ��ü���� DB �۾��� �� �� ����� Connection ��ü�� ����.
		loginDAO.setConnection(con);
		// LoginDAO ��ü�� �α����� ������� ������ Member ��ü�� ��ȯ�ϴ� �޼ҵ�(selectLoginmember)�� ȣ��.
		Member loginMember = loginDAO.selectLoginMember(id,passwd);
		// DB �۾��� ���� �� ����ߴ� Connection ��ü�� �ݾ���.
		close(con);
		// �α��ε� ������� ���� ��ȯ.
		return loginMember;
	}
	
}