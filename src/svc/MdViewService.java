package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.Md;
import dao.MdDAO;

// ���� ��ǰ �� �������� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class MdViewService {

	public Md getMdView(int mdid) {
		
		Connection con = getConnection();
		MdDAO mdDAO = MdDAO.getInstance();
		mdDAO.setConnection(con);
		// �� ������ ��û�ϴ� ���� ��ǰ�� ��ȸ���� ������Ŵ.
		int updateCount = mdDAO.updateHit(mdid);
		
		// ��ȸ�� ������ �������� �� Ʈ������ �۾��� �ϼ���Ŵ.
		if(updateCount>0) {
			commit(con);
		// ��ȸ�� ���� �۾��� �������� �� Ʈ������ �۾��� ��ҽ�Ŵ.
		} else {
			rollback(con);
		}
		
		// �Ķ���ͷ� ���۵� id���� ������ �ִ� ���� ��ǰ ���� �ϳ��� ����.
		Md md = mdDAO.selectMd(mdid);
		close(con);
		
		return md;
	}

}
