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
		// 굿즈 상품 목록을 ArrayList 객체 타입으로 반환하는 메소드를 호출.
		ArrayList<Md> mdList = mdDAO.selectMdList();
		close(con);
		return mdList;
	}
	
}