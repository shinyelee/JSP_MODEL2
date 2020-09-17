package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class BoardDetailService { // �� �� ���� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.

	public BoardBean getArticle(int board) throws Exception {
		
		BoardBean article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCount(board_num); // �� �� ������ �� ���� ��ȸ���� ������Ű�� �޼ҵ带 ȣ��.
		// ��ȸ�� ���� update �۾��� Ʈ������� ó���� ��.
		// ����Ŭ������ �����͸� �����ϴ� �۾��� ������ ���� ���������� �Ͻ��� Ʈ������� ����ǹǷ� �ݵ�� Ʈ������� ó���ϴ� �κ��� �����ؾ� �Ѵ�.
		if(updateCount > 0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		
		article = boardDAO.selectArticle(board_num); // ���ڷ� ������ �۹�ȣ�� ������ ��ȯ�ϴ� �޼ҵ带 ȣ��.
		close(con);
		return article;
		
	}
	
}