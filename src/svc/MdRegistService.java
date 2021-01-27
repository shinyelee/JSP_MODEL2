package svc;

// JdbcUtil Ŭ������ static���� ���ǵǾ� �ִ� �Ӽ��� �޼ҵ带 ���ϰ� ����ϱ� ���ؼ� static import�� ó��.
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MdDAO;
import vo.Md;

public class MdRegistService {

	public boolean registMd(Md md) {
		
		MdDAO mdDAO = MdDAO.getInstance();
		// �����ͺ��̽� �۾��� ó���� MdDAO ��ü�� ����.
		Connection con = getConnection();
		// �����ͺ��̽� �۾��� ���� Connection ��ü�� MdDAO�� ��� ������ ����.
		mdDAO.setConnection(con);		
		// ��� �۾� ���� ���θ� ������ ������ ����.
		boolean isRegistSuccess = false;		
		// �����ͺ��̽��� ���ο� ���� ��ǰ ������ �߰��ϴ� �޼ҵ带 ȣ��.
		int insertCount = mdDAO.insertMd(md);
		
		// ��� �۾��� �������� �� Ʈ����� �۾��� �ϼ���Ŵ.
		if(insertCount>0) {
			commit(con);
			isRegistSuccess=true;
		// ��� �۾��� �������� �� Ʈ����� �۾��� ��ҽ�Ŵ.
		} else {
			rollback(con);
		}
		
		// ����� Connection ��ü�� �ݾ���.
		close(con);
		return isRegistSuccess;
	}

}