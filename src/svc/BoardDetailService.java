package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// �� �� ���� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception {
		
		BoardBean article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// �� �� ������ �� ���� ��ȸ���� ������Ű�� �޼ҵ带 ȣ��.
		int updateCount = boardDAO.updateReadCount(board_num);
		
		// ��ȸ�� ���� update �۾��� Ʈ������� ó���� ��.
		// ����Ŭ������ �����͸� �����ϴ� �۾��� ������ ���� ���������� �Ͻ��� Ʈ������� ����ǹǷ� �ݵ�� Ʈ������� ó���ϴ� �κ��� �����ؾ� �Ѵ�.
		if(updateCount > 0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		
		// ���ڷ� ������ �۹�ȣ�� ������ ��ȯ�ϴ� �޼ҵ带 ȣ��.
		article = boardDAO.selectArticle(board_num);
		close(con);
		return article;
		
	}
	
}