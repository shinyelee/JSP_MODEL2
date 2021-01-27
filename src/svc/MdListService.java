package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.MdDAO;
import vo.Md;

public class MdListService {

	public ArrayList<Md> getMdList() {
		
		MdDAO mdDAO = MdDAO.getInstance();
		Connection con = getConnection();
		mdDAO.setConnection(con);
		// ���� ��ǰ ����� ArrayList ��ü Ÿ������ ��ȯ�ϴ� �޼ҵ带 ȣ��.
		ArrayList<Md> mdList = mdDAO.selectMdList();
		close(con);
		return mdList;
	}
	
}