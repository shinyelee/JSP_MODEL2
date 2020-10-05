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
		ArrayList<Goods> goodsList = goodsDAO.selectGoodsList(); // 굿즈 상품 목록을 ArrayList 객체 타입으로 반환하는 메소드를 호출.
		close(con);
		return goodsList;
	}
	
}

*/