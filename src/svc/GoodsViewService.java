package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.Goods;
import dao.GoodsDAO;

// ���� ��ǰ �� �������� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class GoodsViewService {
	
	public Goods getDogView(int id) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		// �� ������ ��û�ϴ� ���� ��ǰ�� ��ȸ���� ������Ŵ.	
		int updateCount = goodsDAO.updateReadCount(id);
		
		// ��ȸ�� ������ �������� �� Ʈ������ �۾��� �ϼ���Ŵ.
		if(updateCount>0) {
			commit(con);
		// ��ȸ�� ���� �۾��� �������� �� Ʈ������ �۾��� ��ҽ�Ŵ.
		} else {
			rollback(con);
		}
		
		// �Ķ���ͷ� ���۵� id���� ������ �ִ� ���� ��ǰ ���� �ϳ��� ����.
		Goods goods = goodsDAO.selectGoods(id);
		close(con);
		return goods;
	}

}