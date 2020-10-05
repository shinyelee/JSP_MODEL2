/*

package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.GoodsDAO;
import vo.Goods;

public class GoodsListService {

	public ArrayList<Goods> getGoodsList() {
		
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);		
		ArrayList<Goods> goodsList = goodsDAO.selectGoodsList(); // ���� ��ǰ ����� ArrayList ��ü Ÿ������ ��ȯ�ϴ� �޼ҵ带 ȣ��.
		close(con);
		return goodsList;
	}
	
}

*/