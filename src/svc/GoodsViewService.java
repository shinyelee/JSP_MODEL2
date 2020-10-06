/*

package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.Goods;
import dao.GoodsDAO;

public class GoodsViewService {
	
	public Goods getDogView(int id) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);	
		int updateCount = goodsDAO.updateReadCount(id);
		
		if(updateCount>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		Goods goods = goodsDAO.selectGoods(id);
		close(con);
		return goods;
	}

}

*/