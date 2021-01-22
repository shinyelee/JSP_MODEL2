package svc;

// JdbcUtil Ŭ������ static���� ���ǵǾ� �ִ� �Ӽ��� �޼ҵ带 ���ϰ� ����ϱ� ���ؼ� static import�� ó��.
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.GoodsDAO;
import vo.Goods;

public class GoodsRegistService {

	public boolean registGoods(Goods goods) {
		
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection(); // �����ͺ��̽� �۾��� ó���� GoodsDAO ��ü�� ����.
		goodsDAO.setConnection(con); // �����ͺ��̽� �۾��� ���� Connection ��ü�� GoodsDAO�� ��� ������ ����.
		boolean isRegistSuccess = false; // ��� �۾� ���� ���θ� ������ ������ ����.
		int insertCount = goodsDAO.insertGoods(goods); // �����ͺ��̽��� ���ο� ���� ��ǰ ������ �߰��ϴ� �޼ҵ带 ȣ��.
		
		// ��� �۾��� �������� �� Ʈ����� �۾��� �ϼ���Ŵ.
		if(insertCount>0){
			commit(con);
			isRegistSuccess=true;
		// ��� �۾��� �������� �� Ʈ����� �۾��� ��ҽ�Ŵ.
		}else{
			rollback(con);
		}
		
		close(con); // ����� Connection ��ü�� �ݾ���.
		return isRegistSuccess;
	}

}